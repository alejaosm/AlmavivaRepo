package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ConsultasPersonas;
import model.Personas;
import view.FrmPersonas;

/**
 *
 * @author Maleja Gosman
 */
public class ControllerPersonas implements ActionListener {

    private Personas mod;
    private ConsultasPersonas modC;
    private FrmPersonas frm;

    public ControllerPersonas(Personas mod, ConsultasPersonas modC, FrmPersonas frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btn_Insertar.addActionListener(this);
        this.frm.btn_Actualizar.addActionListener(this);
        this.frm.btn_Eliminar.addActionListener(this);
        this.frm.btn_Clear.addActionListener(this);
        this.frm.btn_Buscar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Personas");
        frm.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btn_Insertar) {

            mod.setNombres_Raz(frm.txtNombre.getText());
            mod.setApellidos(frm.txtApellidos.getText());
            mod.setNumero_Doc(Integer.parseInt(frm.txtIdentificacion.getText()));
            mod.setCorreo(frm.txtCorreo.getText());
            mod.setDireccion(frm.txtDir.getText());
            mod.setTelefono(Integer.parseInt(frm.txtTel.getText()));
            mod.setUbicacion(frm.txtUbicacion.getText());
            mod.setRep_Legal(frm.txtRepresent.getText());
            mod.setEstado(frm.lis_Esta.getItemCount());
            mod.setTipo_Persona(frm.list_Tip_Per.getItemCount());
            mod.setTipo_Doc(frm.list_Tip_Doc.getItemCount());

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btn_Actualizar) {
            mod.setNumero_Doc(Integer.parseInt(frm.txt_Search.getText()));
            mod.setNombres_Raz(frm.txtNombre.getText());
            mod.setApellidos(frm.txtApellidos.getText());
            mod.setNumero_Doc(Integer.parseInt(frm.txtIdentificacion.getText()));
            mod.setCorreo(frm.txtCorreo.getText());
            mod.setDireccion(frm.txtDir.getText());
            mod.setTelefono(Integer.parseInt(frm.txtTel.getText()));
            mod.setUbicacion(frm.txtUbicacion.getText());
            mod.setRep_Legal(frm.txtRepresent.getText());
            mod.setEstado(frm.lis_Esta.getItemCount());
            mod.setTipo_Persona(frm.list_Tip_Per.getItemCount());
            mod.setTipo_Doc(frm.list_Tip_Doc.getItemCount());

            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btn_Eliminar) {
            mod.setNumero_Doc(Integer.parseInt(frm.txtIdentificacion.getText()));

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btn_Buscar) {
            mod.setNumero_Doc(Integer.parseInt(frm.txt_Search.getText()));

            if (modC.buscar(mod)) {

                frm.txt_Search.setText(String.valueOf(mod.getNumero_Doc()));
                frm.txtNombre.setText(mod.getNombres_Raz());
                frm.txtApellidos.setText(mod.getApellidos());
                frm.txtIdentificacion.setText(String.valueOf(mod.getNumero_Doc()));
                frm.txtCorreo.setText(mod.getCorreo());
                frm.txtDir.setText(mod.getDireccion());
                frm.txtTel.setText(String.valueOf(mod.getTelefono()));
                frm.txtUbicacion.setText(mod.getUbicacion());
                frm.txtRepresent.setText(mod.getRep_Legal());
               
               
               // mod.setEstado(frm.lis_Esta.getItemCount());
                //mod.setTipo_Persona(frm.list_Tip_Per.getItemCount());
                //mod.setTipo_Doc(frm.list_Tip_Doc.getItemCount());

                

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }

        if (e.getSource() == frm.btn_Clear) {
            limpiar();
        }
    }

    public void limpiar() {

        frm.txtNombre.setText(null);
        frm.txtApellidos.setText(null);
        frm.txtIdentificacion.setText(null);
        frm.txtCorreo.setText(null);
        frm.txtRepresent.setText(null);
        frm.txtDir.setText(null);
        frm.txtTel.setText(null);
        frm.txtUbicacion.setText(null);

    }

}
