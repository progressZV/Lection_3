package com.senla.console.actions.ClientActions;

import com.senla.console.actions.IAction;
import com.senla.facade.AdministratorService;

public class GetClientsAction implements IAction {
    @Override
    public void execute() {
        AdministratorService administratorService = new AdministratorService();
        administratorService.checkAllClients();
    }
}
