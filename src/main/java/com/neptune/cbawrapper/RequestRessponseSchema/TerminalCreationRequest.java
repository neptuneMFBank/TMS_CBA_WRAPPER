package com.neptune.cbawrapper.RequestRessponseSchema;

import java.util.List;

public class TerminalCreationRequest {
    private List<TerminalUsers> users;

    public List<TerminalUsers> getUsers() {
        return users;
    }

    public void setUsers(List<TerminalUsers> users) {
        this.users = users;
    }
}
