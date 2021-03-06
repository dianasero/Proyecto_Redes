package Controlador;
import Vista.*;
import java.util.ArrayList;

public class ControladorGrafico{
    
    //referencia a todas las ventanas del programa
    private VentanaLogin vLogin;
    private VentanaRegistro vRegistro;
    private VentanaContactos vC;
    private VentanaUsuarios vU;
    private VentanaChat vChat;

    public VentanaLogin getvLogin() {
        return vLogin;
    }

    public void setvRegistro(VentanaRegistro vRegistro){
        this.vRegistro = vRegistro;
    }
    
    public VentanaRegistro getvRegistro(){
        return vRegistro;
    }
    
    public void setvLogin(VentanaLogin vLogin) {
        this.vLogin = vLogin;
    }

    public VentanaContactos getvC() {
        return vC;
    }

    public void setvC(VentanaContactos vC) {
        this.vC = vC;
    }

    public VentanaUsuarios getvU() {
        return vU;
    }

    public void setvU(VentanaUsuarios vU) {
        this.vU = vU;
    }

    public VentanaChat getvChat() {
        return vChat;
    }

    public void setvChat(VentanaChat vChat) {
        this.vChat = vChat;
    }  
    
    public void mostrarContactos(){
        if(this.getvC()!= null){
            vC.mostrarContactos();
        }
        //    this.getvC().mostrarContactos();
        else{
            //ventanaContactos vC = new ventanaContactos(modelo.getContactos());
            //por el momento
            ArrayList<String> a = new ArrayList<>();
            for(int i = 0; i < 2; i++)
                a.add("María Fernanda Ramos López -> " + (i+1));
            vC = new VentanaContactos(a);
            vC.setControladorGrafico(this);
            this.setvC(vC);
            vC.setVisible(true);        
        }
    }

    public void mostrarRegistro(){
        VentanaRegistro vR = new VentanaRegistro();
        vR.setControladorGráfico(this);
        vR.setVisible(true);
    }
    
    public void mostrarChat(String nombreContacto){
        if(this.getvChat() != null){
            if(this.getvChat().getTitle().equals(nombreContacto))
                this.getvChat().mostrarChat();
            else{
                VentanaChat vChat = new VentanaChat(nombreContacto);
                this.setvChat(vChat);
                vChat.setControladorGrafico(this);
                vChat.setVisible(true);
            }                
        }else{
            VentanaChat vChat = new VentanaChat(nombreContacto);
            this.setvChat(vChat);
            vChat.setControladorGrafico(this);
            vChat.setVisible(true);
        }
    }
    
    public void mostrarUsuarios(){
        if(this.getvU() != null)
            this.getvU().mostrarUsuarios();
        else{
            ArrayList<String> a = new ArrayList<>();
            for(int i = 0; i < 11; i++)
                a.add("María Fernanda Ramos López -> " + (i+1));
            vU = new VentanaUsuarios(a);
            vU.setControladorGrafico(this);
            this.setvU(vU);
            vU.setVisible(true);        
        }
    }
    
    public void mostrarLogin(){
        vLogin.mostrarLogin();
    }
    
    public boolean existeUsuario(String usuario){
        System.out.println("Usuario: " + usuario );
    //return modelo.existeUsuraio(usuario)
        return false;
    }
    public boolean accedeUsuario(String usuario, String contrasena){
        System.out.println("Usuario: " + usuario + "Contraseña " + contrasena);
        //if(modelo.accedeUsuario(usuario, contrasena))
        return true;
    }
    
    public String getLoginUsuario(){
        
        return vLogin.getUsuario();
    }
    
    public String getLoginPassword(){
        
        return vLogin.getPassword();
    }
    
    public String getRegistroUsuario(){
        
        return vRegistro.getUsuario();
    }
    
    public String getRegistroPassword(){
        
        return vRegistro.getPassword();
    }
}
