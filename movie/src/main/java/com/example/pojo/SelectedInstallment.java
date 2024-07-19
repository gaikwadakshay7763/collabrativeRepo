package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SelectedInstallment {
    @JsonProperty("selectedChoice")
    private String selectedChoice;

    public SelectedInstallment() {
    }

    public SelectedInstallment(String selectedChoice) {
        this.selectedChoice = selectedChoice;
    }

    public String getSelectedChoice() {
        return selectedChoice;
    }

    public void setSelectedChoice(String selectedChoice) {
        this.selectedChoice = selectedChoice;
    }

    @Override
    public String toString() {
        return "SelectedInstallment{" +
                "selectedChoice='" + selectedChoice + '\'' +
                '}';
    }
}
