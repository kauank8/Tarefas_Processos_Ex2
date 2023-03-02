package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class KillController {
	public KillController() {
		super();
	}
	//Verifica e guarda S.O ---------------------------------
	public String NomeSI() {
		String os = System.getProperty("os.name");
		if(os.contains("Windows")) {
			String[] vtos = os.split(" ");
			os = vtos[0];
		}
		else {
				if(os.contains("Linux")) {
					String[] vtos = os.split(" ");
					os = vtos[0];
				}
			}
		
		return os;
	}
	//fim verifica S.O --------------------------------------
	
	//Chama Tabela de Processo ------------------
	public void listaProcessos(String os) {
		if(os.contains("Windows")){
			
			String process="TASKLIST /FO TABLE";
			try {
				Process ip = Runtime.getRuntime().exec(process);
				InputStream fluxo = ip.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
					while(linha!=null) {
					System.out.println(linha);
					linha=buffer.readLine();
					}		
					fluxo.close();
					leitor.close();
					buffer.close();
					
				}
			catch (Exception e) {
				e.printStackTrace();	
			}
		}
		//linux ------------------------------>
		if(os.contains("Linux")){
			
			String process="ps -ef";
			try {
				Process ip = Runtime.getRuntime().exec(process);
				InputStream fluxo = ip.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
					while(linha!=null) {
					System.out.println(linha);
					linha=buffer.readLine();
					}		
					fluxo.close();
					leitor.close();
					buffer.close();
					
				}
			catch (Exception e) {
				e.printStackTrace();	
			}
		}//fim linux ----------------------------------->
	}
	
	// Kill Pid
	public void killPid(String os, String param) {
		if(os.contains("Windows")) {
		String cmdpid = "TASKKIll /PID";
		int pid=0;
		StringBuffer buffer = new StringBuffer();
		try {
			pid=Integer.parseInt(param);
			buffer.append(cmdpid);
			buffer.append(" ");
			buffer.append(pid);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Formato invalido ou PID inexistente");
		}
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} 
		catch (Exception e) {
			e.printStackTrace();
			}
		}
		
		//linux-------------------------------->
		if(os.contains("Linux")) {
			String cmdpid = "kill -9";
			int pid=0;
			StringBuffer buffer = new StringBuffer();
			try {
				pid=Integer.parseInt(param);
				buffer.append(cmdpid);
				buffer.append(" ");
				buffer.append(pid);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Formato invalido ou PID inexistente");
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} 
			catch (Exception e) {
				e.printStackTrace();
				}
			} // fim linux---------------------->
		
	} // fim Kill Pid;
	
	// Inicio Kill Nome
	public void killNome(String os, String param) {
			if(os.contains("Windows")) {
			String cmdnome = "TASKKILL /IM";
			
			StringBuffer buffer = new StringBuffer();
			try {
				buffer.append(cmdnome);
				buffer.append(" ");
				buffer.append(param);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Formato invalido ou Nome inexistente");
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} 
			catch (Exception e) {
				e.printStackTrace();
				}
			}
	
			
			//linux-------------------------------->
			if(os.contains("Linux")) {
				String cmdnome = "pkill -f";
				StringBuffer buffer = new StringBuffer();
				try {
					buffer.append(cmdnome);
					buffer.append(" ");
					buffer.append(param);
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "Formato invalido ou nome inexistente");
				}
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} 
				catch (Exception e) {
					e.printStackTrace();
					}
				} // fim linux---------------------->
		}// fim kill nome --------------------------------------->
	
}	