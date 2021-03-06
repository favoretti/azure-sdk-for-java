/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.azure.management.containerregistry.implementation;

import com.azure.management.containerregistry.AgentProperties;
import com.azure.management.containerregistry.Architecture;
import com.azure.management.containerregistry.BaseImageTrigger;
import com.azure.management.containerregistry.BaseImageTriggerType;
import com.azure.management.containerregistry.BaseImageTriggerUpdateParameters;
import com.azure.management.containerregistry.DockerBuildStepUpdateParameters;
import com.azure.management.containerregistry.DockerTaskStep;
import com.azure.management.containerregistry.EncodedTaskStep;
import com.azure.management.containerregistry.EncodedTaskStepUpdateParameters;
import com.azure.management.containerregistry.FileTaskStep;
import com.azure.management.containerregistry.FileTaskStepUpdateParameters;
import com.azure.management.containerregistry.OS;
import com.azure.management.containerregistry.PlatformProperties;
import com.azure.management.containerregistry.PlatformUpdateParameters;
import com.azure.management.containerregistry.ProvisioningState;
import com.azure.management.containerregistry.RegistryDockerTaskStep;
import com.azure.management.containerregistry.RegistryEncodedTaskStep;
import com.azure.management.containerregistry.RegistryFileTaskStep;
import com.azure.management.containerregistry.RegistrySourceTrigger;
import com.azure.management.containerregistry.RegistryTask;
import com.azure.management.containerregistry.RegistryTaskStep;
import com.azure.management.containerregistry.SourceProperties;
import com.azure.management.containerregistry.SourceTrigger;
import com.azure.management.containerregistry.SourceTriggerUpdateParameters;
import com.azure.management.containerregistry.SourceUpdateParameters;
import com.azure.management.containerregistry.TaskStatus;
import com.azure.management.containerregistry.TaskUpdateParameters;
import com.azure.management.containerregistry.TriggerProperties;
import com.azure.management.containerregistry.TriggerStatus;
import com.azure.management.containerregistry.TriggerUpdateParameters;
import com.azure.management.containerregistry.Variant;
import com.azure.management.containerregistry.models.TaskInner;
import com.azure.management.containerregistry.models.TasksInner;
import com.azure.management.resources.fluentcore.arm.Region;
import com.azure.management.resources.fluentcore.arm.ResourceUtils;
import com.azure.management.resources.fluentcore.model.Indexable;
import com.azure.management.resources.fluentcore.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class RegistryTaskImpl implements
        RegistryTask,
        RegistryTask.Definition,
        RegistryTask.Update {

    private final TasksInner tasksInner;
    private final String taskName;
    private final String key = UUID.randomUUID().toString();
    private String resourceGroupName;
    private String registryName;
    private TaskInner inner;
    TaskUpdateParameters taskUpdateParameters;
    private RegistryTaskStep registryTaskStep;

    @Override
    public String id() {
        return this.inner().getId();
    }

    @Override
    public String name() {
        return this.inner().getName();
    }

    @Override
    public String type() {
        return this.inner().getType();
    }

    @Override
    public String regionName() {
        return this.inner().getLocation();
    }

    @Override
    public Region region() {
        return Region.fromName(this.regionName());
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().getTags();
    }

    @Override
    public String resourceGroupName() {
        return ResourceUtils.groupFromResourceId(this.id());
    }

    @Override
    public String parentRegistryId() {
        return ResourceUtils.parentResourceIdFromResourceId(this.id());
    }

    @Override
    public ProvisioningState provisioningState() {
        return this.inner.provisioningState();
    }

    @Override
    public OffsetDateTime creationDate() {
        return this.inner.creationDate();
    }

    @Override
    public TaskStatus status() {
        return this.inner.status();
    }

    @Override
    public TaskInner inner() {
        return this.inner;
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public RegistryTaskStep registryTaskStep() {
        if (this.registryTaskStep != null) {
            return this.registryTaskStep;
        }
        if (this.inner.step() instanceof FileTaskStep) {
            this.registryTaskStep = new RegistryFileTaskStepImpl(this);
        } else if (this.inner.step() instanceof EncodedTaskStep) {
            this.registryTaskStep = new RegistryEncodedTaskStepImpl(this);
        } else if (this.inner.step() instanceof DockerTaskStep) {
            this.registryTaskStep = new RegistryDockerTaskStepImpl(this);
        }
        return this.registryTaskStep;
    }

    @Override
    public int timeout() {
        return Utils.toPrimitiveInt(this.inner.timeout());
    }

    @Override
    public PlatformProperties platform() {
        return this.inner.platform();
    }

    @Override
    public int cpuCount() {
        if (this.inner.agentConfiguration() == null) {
            return 0;
        }
        return Utils.toPrimitiveInt(this.inner.agentConfiguration().cpu());
    }

    @Override
    public TriggerProperties trigger() {
        return this.inner.trigger();
    }

    @Override
    public Map<String, RegistrySourceTrigger> sourceTriggers() {
        Map<String, RegistrySourceTrigger> sourceTriggerMap = new HashMap<String, RegistrySourceTrigger>();
        for (SourceTrigger sourceTrigger : this.inner.trigger().sourceTriggers()) {
            sourceTriggerMap.put(sourceTrigger.name(), new RegistrySourceTriggerImpl(sourceTrigger.name(), this, false));
        }
        return sourceTriggerMap;
    }

    RegistryTaskImpl(ContainerRegistryManager registryManager, String taskName) {
        this.tasksInner = registryManager.inner().tasks();
        this.taskName = taskName;
        this.inner = new TaskInner();
        this.taskUpdateParameters = new TaskUpdateParameters();
    }

    RegistryTaskImpl(ContainerRegistryManager registryManager, TaskInner inner) {
        this.tasksInner = registryManager.inner().tasks();
        this.taskName = inner.getName();
        this.inner = inner;
        this.resourceGroupName = ResourceUtils.groupFromResourceId(this.inner.getId());
        this.registryName = ResourceUtils.nameFromResourceId(ResourceUtils.parentResourceIdFromResourceId(this.inner.getId()));
        this.taskUpdateParameters = new TaskUpdateParameters();
        setTaskUpdateParameterTriggers();
    }

    @Override
    public DefinitionStages.Location withExistingRegistry(String resourceGroupName, String registryName) {
        this.resourceGroupName = resourceGroupName;
        this.registryName = registryName;
        return this;
    }

    @Override
    public RegistryFileTaskStep.DefinitionStages.Blank defineFileTaskStep() {
        return new RegistryFileTaskStepImpl(this);
    }

    @Override
    public RegistryEncodedTaskStep.DefinitionStages.Blank defineEncodedTaskStep() {
        return new RegistryEncodedTaskStepImpl(this);
    }

    @Override
    public RegistryDockerTaskStep.DefinitionStages.Blank defineDockerTaskStep() {
        return new RegistryDockerTaskStepImpl(this);
    }

    @Override
    public DefinitionStages.Platform withLocation(String location) {
        this.inner.setLocation(location);
        return this;
    }

    @Override
    public DefinitionStages.Platform withLocation(Region location) {
        this.inner.setLocation(location.toString());
        return this;
    }

    @Override
    public RegistryTaskImpl withLinux() {
        if (isInCreateMode()) {
            if (this.inner.platform() == null) {
                this.inner.withPlatform(new PlatformProperties());
            }
            this.inner.platform().withOs(OS.LINUX);
        } else {
            if (this.taskUpdateParameters.platform() == null) {
                this.taskUpdateParameters.withPlatform(new PlatformUpdateParameters());
            }
            this.taskUpdateParameters.platform().withOs(OS.LINUX);
        }
        return this;
    }

    @Override
    public RegistryTaskImpl withWindows() {
        if (isInCreateMode()) {
            if (this.inner.platform() == null) {
                this.inner.withPlatform(new PlatformProperties());
            }
            this.inner.platform().withOs(OS.WINDOWS);
        } else {
            if (this.taskUpdateParameters.platform() == null) {
                this.taskUpdateParameters.withPlatform(new PlatformUpdateParameters());
            }
            this.taskUpdateParameters.platform().withOs(OS.WINDOWS);
        }
        return this;
    }

    @Override
    public RegistryTaskImpl withLinux(Architecture architecture) {
        if (isInCreateMode()) {
            if (this.inner.platform() == null) {
                this.inner.withPlatform(new PlatformProperties());
            }
            this.inner.platform().withOs(OS.LINUX).withArchitecture(architecture);
        } else {
            if (this.taskUpdateParameters.platform() == null) {
                this.taskUpdateParameters.withPlatform(new PlatformUpdateParameters());
            }
            this.taskUpdateParameters.platform().withOs(OS.LINUX).withArchitecture(architecture);
        }
        return this;
    }

    @Override
    public RegistryTaskImpl withWindows(Architecture architecture) {
        if (isInCreateMode()) {
            if (this.inner.platform() == null) {
                this.inner.withPlatform(new PlatformProperties());
            }
            this.inner.platform().withOs(OS.WINDOWS).withArchitecture(architecture);
        } else {
            if (this.taskUpdateParameters.platform() == null) {
                this.taskUpdateParameters.withPlatform(new PlatformUpdateParameters());
            }
            this.taskUpdateParameters.platform().withOs(OS.WINDOWS).withArchitecture(architecture);
        }
        return this;
    }

    @Override
    public RegistryTaskImpl withLinux(Architecture architecture, Variant variant) {
        if (isInCreateMode()) {
            if (this.inner.platform() == null) {
                this.inner.withPlatform(new PlatformProperties());
            }
            this.inner.platform().withOs(OS.LINUX).withArchitecture(architecture).withVariant(variant);
        } else {
            if (this.taskUpdateParameters.platform() == null) {
                this.taskUpdateParameters.withPlatform(new PlatformUpdateParameters());
            }
            this.taskUpdateParameters.platform().withOs(OS.LINUX).withArchitecture(architecture).withVariant(variant);
        }
        return this;
    }

    @Override
    public RegistryTaskImpl withWindows(Architecture architecture, Variant variant) {
        if (isInCreateMode()) {
            if (this.inner.platform() == null) {
                this.inner.withPlatform(new PlatformProperties());
            }
            this.inner.platform().withOs(OS.WINDOWS).withArchitecture(architecture).withVariant(variant);
        } else {
            if (this.taskUpdateParameters.platform() == null) {
                this.taskUpdateParameters.withPlatform(new PlatformUpdateParameters());
            }
            this.taskUpdateParameters.platform().withOs(OS.WINDOWS).withArchitecture(architecture).withVariant(variant);
        }
        return this;
    }

    @Override
    public RegistryTaskImpl withPlatform(PlatformProperties platformProperties) {
        this.inner.withPlatform(platformProperties);
        return this;
    }

    @Override
    public RegistryTaskImpl withPlatform(PlatformUpdateParameters platformProperties) {
        this.taskUpdateParameters.withPlatform(platformProperties);
        return this;
    }

    @Override
    public RegistrySourceTriggerImpl defineSourceTrigger(String sourceTriggerName) {
        if (isInCreateMode()) {
            if (this.inner.trigger() == null) {
                this.inner.withTrigger(new TriggerProperties());
            }
            if (this.inner.trigger().sourceTriggers() == null) {
                this.inner.trigger().withSourceTriggers(new ArrayList<SourceTrigger>());
            }
            return new RegistrySourceTriggerImpl(sourceTriggerName, this, true);
        } else {
            this.taskUpdateParameters = new TaskUpdateParameters();
            this.setTaskUpdateParameterTriggers();
            return new RegistrySourceTriggerImpl(sourceTriggerName, this, true);
        }

    }

    @Override
    public DefinitionStages.TaskCreatable withBaseImageTrigger(String baseImageTriggerName, BaseImageTriggerType baseImageTriggerType) {
        if (this.inner.trigger() == null) {
            this.inner.withTrigger(new TriggerProperties());
        }
        this.inner.trigger().withBaseImageTrigger(new BaseImageTrigger()
                                                    .withBaseImageTriggerType(baseImageTriggerType)
                                                    .withName(baseImageTriggerName));
        return this;
    }

    @Override
    public DefinitionStages.TaskCreatable withBaseImageTrigger(String baseImageTriggerName, BaseImageTriggerType baseImageTriggerType, TriggerStatus triggerStatus) {
        if (this.inner.trigger() == null) {
            this.inner.withTrigger(new TriggerProperties());
        }
        this.inner.trigger().withBaseImageTrigger(new BaseImageTrigger()
                                                    .withBaseImageTriggerType(baseImageTriggerType)
                                                    .withName(baseImageTriggerName)
                                                    .withStatus(triggerStatus));
        return this;
    }

    @Override
    public RegistryTaskImpl withCpuCount(int count) {
        if (isInCreateMode()) {
            if (this.inner.agentConfiguration() == null) {
                this.inner.withAgentConfiguration(new AgentProperties());
            }
            this.inner.agentConfiguration().withCpu(count);
        } else {
            if (this.taskUpdateParameters.agentConfiguration() == null) {
                this.taskUpdateParameters.withAgentConfiguration(new AgentProperties());
            }
            this.taskUpdateParameters.agentConfiguration().withCpu(count);
        }
        return this;
    }

    @Override
    public RegistryTaskImpl withTimeout(int timeout) {
        if (isInCreateMode()) {
            this.inner.withTimeout(timeout);
        } else {
            this.taskUpdateParameters.withTimeout(timeout);
        }
        return this;
    }

    @Override
    public RegistryTask create() {
        return (RegistryTask) createAsync().blockLast();
    }

    @Override
    public Flux<Indexable> createAsync() {
        final RegistryTaskImpl self = this;
        return this.tasksInner.createAsync(this.resourceGroupName, this.registryName, this.taskName, this.inner)
            .flatMapMany(taskInner -> {
                self.inner = taskInner;
                self.taskUpdateParameters = new TaskUpdateParameters();
                self.setTaskUpdateParameterTriggers();
                return Mono.just(self);
            });
    }

    @Override
    public RegistryTask refresh() {
        return refreshAsync().block();
    }

    @Override
    public Mono<RegistryTask> refreshAsync() {
        final RegistryTaskImpl self = this;
        return this.tasksInner.getAsync(this.resourceGroupName, this.registryName, this.taskName)
            .map(taskInner -> {
                self.inner = taskInner;
                self.taskUpdateParameters = new TaskUpdateParameters();
                self.setTaskUpdateParameterTriggers();
                return self;
            });
    }

    @Override
    public RegistryFileTaskStep.Update updateFileTaskStep() {
        if (!(this.inner.step() instanceof FileTaskStep)) {
            throw new UnsupportedOperationException("Calling updateFileTaskStep on a RegistryTask that is of type " + this.inner.step().getClass().getName() + ".");
        }
        return new RegistryFileTaskStepImpl(this);
    }

    @Override
    public RegistryEncodedTaskStep.Update updateEncodedTaskStep() {
        if (!(this.inner.step() instanceof EncodedTaskStep)) {
            throw new UnsupportedOperationException("Calling updateEncodedTaskStep on a RegistryTask that is of type " + this.inner.step().getClass().getName() + ".");
        }
        return new RegistryEncodedTaskStepImpl(this);
    }

    @Override
    public RegistryDockerTaskStep.Update updateDockerTaskStep() {
        if (!(this.inner.step() instanceof DockerTaskStep)) {
            throw new UnsupportedOperationException("Calling updateDockerTaskStep on a RegistryTask that is of type " + this.inner.step().getClass().getName() + ".");
        }
        return new RegistryDockerTaskStepImpl(this);
    }


    @Override
    public RegistrySourceTrigger.Update updateSourceTrigger(String sourceTriggerName) {
        return new RegistrySourceTriggerImpl(sourceTriggerName, this, false);
    }

    @Override
    public Update updateBaseImageTrigger(String baseImageTriggerName, BaseImageTriggerType baseImageTriggerType) {
        this.taskUpdateParameters.trigger().withBaseImageTrigger(new BaseImageTriggerUpdateParameters()
                                                                .withBaseImageTriggerType(baseImageTriggerType)
                                                                .withName(baseImageTriggerName));
        return this;
    }

    @Override
    public Update updateBaseImageTrigger(String baseImageTriggerName, BaseImageTriggerType baseImageTriggerType, TriggerStatus triggerStatus) {
        this.taskUpdateParameters.trigger().withBaseImageTrigger(new BaseImageTriggerUpdateParameters()
                                                                .withBaseImageTriggerType(baseImageTriggerType)
                                                                .withName(baseImageTriggerName)
                                                                .withStatus(triggerStatus));
        return this;
    }

    @Override
    public Update update() {
        return this;
    }

    @Override
    public RegistryTask apply() {
        return applyAsync().block();
    }

    @Override
    public Mono<RegistryTask> applyAsync() {
        final RegistryTaskImpl self = this;
        return this.tasksInner.updateAsync(this.resourceGroupName, this.registryName, this.taskName, this.taskUpdateParameters)
            .map(taskInner -> {
                self.inner = taskInner;
                self.taskUpdateParameters = new TaskUpdateParameters();
                self.registryTaskStep = null;
                self.taskUpdateParameters = new TaskUpdateParameters();
                self.setTaskUpdateParameterTriggers();
                return self;
            });
    }

    private boolean isInCreateMode() {
        if (this.inner().getId() == null) {
            return true;
        }
        return false;
    }

    void withFileTaskStepCreateParameters(FileTaskStep fileTaskStep) {
        this.inner.withStep(fileTaskStep);
    }

    void withFileTaskStepUpdateParameters(FileTaskStepUpdateParameters fileTaskStepUpdateParameters) {
        this.taskUpdateParameters.withStep(fileTaskStepUpdateParameters);
    }

    void withEncodedTaskStepCreateParameters(EncodedTaskStep encodedTaskStep) {
        this.inner.withStep(encodedTaskStep);
    }

    void withEncodedTaskStepUpdateParameters(EncodedTaskStepUpdateParameters encodedTaskStepUpdateParameters) {
        this.taskUpdateParameters.withStep(encodedTaskStepUpdateParameters);
    }

    void withDockerTaskStepCreateParameters(DockerTaskStep dockerTaskStep) {
        this.inner.withStep(dockerTaskStep);
    }

    void withDockerTaskStepUpdateParameters(DockerBuildStepUpdateParameters dockerTaskStepUpdateParameters) {
        this.taskUpdateParameters.withStep(dockerTaskStepUpdateParameters);
    }

    void withSourceTriggerCreateParameters(SourceTrigger sourceTrigger) {
        List<SourceTrigger> sourceTriggers = this.inner.trigger().sourceTriggers();
        sourceTriggers.add(sourceTrigger);
        this.inner.trigger().withSourceTriggers(sourceTriggers);
    }

    void withSourceTriggerUpdateParameters(SourceTriggerUpdateParameters sourceTriggerUpdateParameters) {
        List<SourceTriggerUpdateParameters> sourceTriggerUpdateParametersList = this.taskUpdateParameters.trigger().sourceTriggers();
        sourceTriggerUpdateParametersList.add(sourceTriggerUpdateParameters);
        this.taskUpdateParameters.trigger().withSourceTriggers(sourceTriggerUpdateParametersList);
    }

    void setTaskUpdateParameterTriggers() {
        if (this.taskUpdateParameters.trigger() == null) {
            this.taskUpdateParameters.withTrigger(new TriggerUpdateParameters());
        }
        //Clone the source triggers
        if (this.inner.trigger() == null) {
            return;
        }
        if (this.inner.trigger().sourceTriggers() != null) {
            List<SourceTriggerUpdateParameters> sourceTriggerUpdateParameters = new ArrayList<SourceTriggerUpdateParameters>();
            for (SourceTrigger sourceTrigger : this.inner.trigger().sourceTriggers()) {
                sourceTriggerUpdateParameters.add(sourceTriggerToSourceTriggerUpdateParameters(sourceTrigger));
            }
            this.taskUpdateParameters.trigger().withSourceTriggers(sourceTriggerUpdateParameters);
        }
        //Clone the base image trigger
        if (this.inner.trigger().baseImageTrigger() != null) {
            this.taskUpdateParameters.trigger().withBaseImageTrigger(setTaskUpdateParameterBaseImageTrigger());
        }
    }

    BaseImageTriggerUpdateParameters setTaskUpdateParameterBaseImageTrigger() {
        BaseImageTriggerUpdateParameters baseImageTriggerUpdateParameters = new BaseImageTriggerUpdateParameters();
        baseImageTriggerUpdateParameters.withName(this.inner.trigger().baseImageTrigger().name());
        baseImageTriggerUpdateParameters.withBaseImageTriggerType(this.inner.trigger().baseImageTrigger().baseImageTriggerType());
        baseImageTriggerUpdateParameters.withStatus(this.inner.trigger().baseImageTrigger().status());
        return baseImageTriggerUpdateParameters;
    }

    SourceTriggerUpdateParameters sourceTriggerToSourceTriggerUpdateParameters(SourceTrigger sourceTrigger) {
        SourceTriggerUpdateParameters sourceTriggerUpdateParameters = new SourceTriggerUpdateParameters();

        sourceTriggerUpdateParameters.withName(sourceTrigger.name());
        sourceTriggerUpdateParameters.withSourceRepository(sourcePropertiesToSourceUpdateParameters(sourceTrigger.sourceRepository()));
        sourceTriggerUpdateParameters.withStatus(sourceTrigger.status());
        sourceTriggerUpdateParameters.withSourceTriggerEvents(sourceTrigger.sourceTriggerEvents());

        return sourceTriggerUpdateParameters;
    }

    SourceUpdateParameters sourcePropertiesToSourceUpdateParameters(SourceProperties sourceProperties) {
        SourceUpdateParameters sourceUpdateParameters = new SourceUpdateParameters();

        sourceUpdateParameters.withSourceControlType(sourceProperties.sourceControlType());
        sourceUpdateParameters.withRepositoryUrl(sourceProperties.repositoryUrl());
        sourceUpdateParameters.withBranch(sourceProperties.branch());
        sourceUpdateParameters.withSourceControlAuthProperties(null);

        return sourceUpdateParameters;
    }

}
