/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.knowledge.qnamaker.models;

import java.util.List;

/**
 * The TrainOptionalParameter model.
 */
public class TrainOptionalParameter {
    /**
     * List of feedback records.
     */
    private List<FeedbackRecordDTO> feedbackRecords;

    /**
     * Gets or sets the preferred language for the response.
     */
    private String thisclientacceptLanguage;

    /**
     * Get the feedbackRecords value.
     *
     * @return the feedbackRecords value
     */
    public List<FeedbackRecordDTO> feedbackRecords() {
        return this.feedbackRecords;
    }

    /**
     * Set the feedbackRecords value.
     *
     * @param feedbackRecords the feedbackRecords value to set
     * @return the TrainOptionalParameter object itself.
     */
    public TrainOptionalParameter withFeedbackRecords(List<FeedbackRecordDTO> feedbackRecords) {
        this.feedbackRecords = feedbackRecords;
        return this;
    }

    /**
     * Get the thisclientacceptLanguage value.
     *
     * @return the thisclientacceptLanguage value
     */
    public String thisclientacceptLanguage() {
        return this.thisclientacceptLanguage;
    }

    /**
     * Set the thisclientacceptLanguage value.
     *
     * @param thisclientacceptLanguage the thisclientacceptLanguage value to set
     * @return the TrainOptionalParameter object itself.
     */
    public TrainOptionalParameter withThisclientacceptLanguage(String thisclientacceptLanguage) {
        this.thisclientacceptLanguage = thisclientacceptLanguage;
        return this;
    }

}
