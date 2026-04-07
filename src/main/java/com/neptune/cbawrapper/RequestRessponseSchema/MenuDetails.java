package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Data;

@Data
public class MenuDetails {
    private MenuData menuData;
    private TerminalProfile terminalProfile;

    public TerminalProfile getTerminalProfile() {
        return terminalProfile;
    }

    public void setTerminalProfile(TerminalProfile terminalProfile) {
        this.terminalProfile = terminalProfile;
    }
}
