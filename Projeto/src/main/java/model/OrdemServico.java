package model;

public class OrdemServico {
    private int ordemServicoId;
    private int clienteId;
    private String nomeEquipamento;
    private String fabricante;
    private String modelo;
    private String defeito;
    private String observacao;

    

    public OrdemServico(int ordemServicoId, int clienteId, String nomeEquipamento, String fabricante, String modelo, String defeito, String observacao) {
        this.ordemServicoId = ordemServicoId;
        this.clienteId = clienteId;
        this.nomeEquipamento = nomeEquipamento;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.defeito = defeito;
        this.observacao = observacao;
    }

    // Getters and Setters
    public int getOrdemServicoId() {
        return ordemServicoId;
    }

    public void setOrdemServicoId(int ordemServicoId) {
        this.ordemServicoId = ordemServicoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
