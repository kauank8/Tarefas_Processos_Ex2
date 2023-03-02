package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String args[]) {
		int opc=0;
		KillController kill = new KillController();
		String os = kill.NomeSI();
		while(opc!=9) {
			opc=Integer.parseInt(JOptionPane.showInputDialog("1-Lista de Processo\n2-Mata Processo Pid\n3-Mata Processo Nome\n9-Finaliza"));
			switch(opc){
						case 1: kill.listaProcessos(os);
								break;
						case 2: String parem = JOptionPane.showInputDialog("Digite o pid do processo");
								kill.killPid(os, parem);	
								break;
						case 3: String parem1 = JOptionPane.showInputDialog("Digite o nome do processo");
								kill.killNome(os, parem1);	
								break;		
						case 9: JOptionPane.showMessageDialog(null, "Finalizado");
								break;
						default:JOptionPane.showMessageDialog(null, "Opcao Invailida");
								break; 								
			
			}
		}
	}

}
