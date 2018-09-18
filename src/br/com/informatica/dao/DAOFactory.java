package br.com.informatica.dao;

public class DAOFactory {

    public static ClienteDAO getClienteDao() { return new ClienteJSONDAO(); }

    public static EquipamentoDAO getEquipamentoDAO() { return new EquipamentoJSONDAO(); }

    public static ResponsavelDAO getResponsavelDAO() {
        return new ResponsavelJSONDAO();
    }

    public static LocalDAO getLocalDAO() {return new LocalJSONDAO();}
}
