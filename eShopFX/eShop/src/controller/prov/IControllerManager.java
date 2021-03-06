package controller.prov;

import javafx.collections.ObservableList;
import utils.Produto;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: App
 * Component: Controller
 * 
 * This 'IControllerManager' interface is provided by the component 'Controller'. All 
 * signatures to business methods present here should be updated on the components that 
 * have this 'IControllerManager' interface as required.
 */
public interface IControllerManager {
	public Produto buscaProdutoController(String nome);
	public String pagarComBoletoController(float valor);
	public String pagarComTransferenciaController(float valor);
	public float calcularTrocoREALController(float valorA , float valorB );
	public ObservableList<Produto> searchAllProducts();
	public boolean registrarCompraRealController();
	public String pagarComCartaoDeCreditoController(int cartao ,float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	public boolean conectaVISA();
	public boolean conectaMASTER();

    //TODO: Signatures of business methods

	//This interface must be equivalent to the 
	//required interfaces in client components
}