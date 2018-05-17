package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ConEstado;
import model.ConTipoPer;
import model.ConTipDoc;
import model.ConsultasPersonas;
import model.Estado;
import model.Personas;
import model.TipoPer;
import model.TipoDoc;
import view.FrmPersonas;

/**
 *
 * @author Maleja Gosman
 */
public class ControllerPersonas implements ActionListener {

    private Personas mod;
    private ConsultasPersonas modC;
    private FrmPersonas frm;
    private ConTipoPer modCT;
    private TipoPer modTip;

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

    public ControllerPersonas() {
    }

    public void iniciar() {
        frm.setTitle("Personas");
        frm.setLocationRelativeTo(null);

        frm.list_Tip_Per.removeAllItems();
        frm.list_Tip_Doc.removeAllItems();
        frm.lis_Esta.removeAllItems();
        frm.lblRepresent.setVisible(false);
        frm.txtRepresent.setVisible(false);

        ArrayList<TipoPer> lista = new ConTipoPer().llenar_combo();
        for (int i = 0; i < lista.size(); i++) {
            frm.list_Tip_Per.addItem(lista.get(i));
        }

        ArrayList<TipoDoc> lista_Doc = new ConTipDoc().llenar_combo();
        for (int i = 0; i < lista_Doc.size(); i++) {
            frm.list_Tip_Doc.addItem(lista_Doc.get(i));
        }

        ArrayList<Estado> lista_Est = new ConEstado().llenar_combo();
        for (int i = 0; i < lista_Est.size(); i++) {
            frm.lis_Esta.addItem(lista_Est.get(i));
        }

        frm.list_Tip_Per.addItemListener(new ItemListener() {
            //
            // Listening if a new items of the combo box has been selected.
            //
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    TipoPer tmp = (TipoPer) frm.list_Tip_Per.getSelectedItem();
                    boolean estado = true;
                    if (tmp.getId_Tipo_Persona() == 1) {
                        estado = false;
                    }
                    frm.lblRepresent.setVisible(estado);
                    frm.txtRepresent.setVisible(estado);
                }
            }
        });
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

            TipoPer tmp = (TipoPer) frm.list_Tip_Per.getSelectedItem();
            mod.setTipo_Persona(tmp.getId_Tipo_Persona());

            TipoDoc tmp1 = (TipoDoc) frm.list_Tip_Doc.getSelectedItem();
            mod.setTipo_Doc(tmp1.getId_Tipo_Doc());

            Estado tmp2 = (Estado) frm.lis_Esta.getSelectedItem();
            mod.setEstado(tmp2.getId_Estado());

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btn_Actualizar) {
            mod.setId_Persona(Integer.parseInt(frm.txtID.getText()));
            mod.setNumero_Doc(Integer.parseInt(frm.txt_Search.getText()));
            mod.setNombres_Raz(frm.txtNombre.getText());
            mod.setApellidos(frm.txtApellidos.getText());
            mod.setNumero_Doc(Integer.parseInt(frm.txtIdentificacion.getText()));
            mod.setCorreo(frm.txtCorreo.getText());
            mod.setDireccion(frm.txtDir.getText());
            mod.setTelefono(Integer.parseInt(frm.txtTel.getText()));
            mod.setUbicacion(frm.txtUbicacion.getText());
            mod.setRep_Legal(frm.txtRepresent.getText());

            TipoPer tmp = (TipoPer) frm.list_Tip_Per.getSelectedItem();
            mod.setTipo_Persona(tmp.getId_Tipo_Persona());

            TipoDoc tmp1 = (TipoDoc) frm.list_Tip_Doc.getSelectedItem();
            mod.setTipo_Doc(tmp1.getId_Tipo_Doc());

            Estado tmp2 = (Estado) frm.lis_Esta.getSelectedItem();
            mod.setEstado(tmp2.getId_Estado());

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
                frm.txtID.setText("" + mod.getId_Persona());
                frm.txt_Search.setText(String.valueOf(mod.getNumero_Doc()));
                frm.txtNombre.setText(mod.getNombres_Raz());
                frm.txtApellidos.setText(mod.getApellidos());
                frm.txtIdentificacion.setText(String.valueOf(mod.getNumero_Doc()));
                frm.txtCorreo.setText(mod.getCorreo());
                frm.txtDir.setText(mod.getDireccion());
                frm.txtTel.setText(String.valueOf(mod.getTelefono()));
                frm.txtUbicacion.setText(mod.getUbicacion());
                frm.txtRepresent.setText(mod.getRep_Legal());

                frm.list_Tip_Per.removeAllItems();
                ArrayList<TipoPer> lista = new ConTipoPer().llenar_combo();
                for (int i = 0; i < lista.size(); i++) {
                    frm.list_Tip_Per.addItem(lista.get(i));
                    if (mod.getTipo_Persona() == lista.get(i).getId_Tipo_Persona()) {
                        frm.list_Tip_Per.setSelectedIndex(i);
                    }
                }

                frm.list_Tip_Doc.removeAllItems();
                ArrayList<TipoDoc> lista_Doc = new ConTipDoc().llenar_combo();
                for (int i = 0; i < lista_Doc.size(); i++) {
                    frm.list_Tip_Doc.addItem(lista_Doc.get(i));
                    if (mod.getTipo_Doc() == lista_Doc.get(i).getId_Tipo_Doc()) {
                        frm.list_Tip_Doc.setSelectedIndex(i);
                    }
                }

                frm.lis_Esta.removeAllItems();
                ArrayList<Estado> lista_Est = new ConEstado().llenar_combo();
                for (int i = 0; i < lista_Est.size(); i++) {
                    frm.lis_Esta.addItem(lista_Est.get(i));
                    if (mod.getEstado() == lista_Est.get(i).getId_Estado()) {
                        frm.lis_Esta.setSelectedIndex(i);
                    }
                }

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
        frm.txtID.setText(null);
        frm.txt_Search.setText(null);

    }

}
