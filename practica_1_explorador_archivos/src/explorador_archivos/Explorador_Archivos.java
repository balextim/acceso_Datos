/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explorador_archivos;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Breyner
 */
public class Explorador_Archivos extends javax.swing.JFrame {

    /**
     * Creates new form Explorador_Archivos
     */
    public Explorador_Archivos() {
        initComponents();
        setTitle("Explorador de archivos");
        tDocumentos.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lRutaDirectorio = new javax.swing.JLabel();
        tfRuta = new javax.swing.JTextField();
        lExtension = new javax.swing.JLabel();
        tfExtension = new javax.swing.JTextField();
        bBuscarRuta = new javax.swing.JButton();
        bBuscarExtension = new javax.swing.JButton();
        lErrores = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDocumentos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lRutaDirectorio.setText("Indique directorio");

        lExtension.setText("Indique extensión");

        bBuscarRuta.setText("Buscar");
        bBuscarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarRutaActionPerformed(evt);
            }
        });

        bBuscarExtension.setText("Buscar");
        bBuscarExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarExtensionActionPerformed(evt);
            }
        });

        tDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Extensión", "Tamaño", "F/D"
            }
        ));
        jScrollPane1.setViewportView(tDocumentos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lRutaDirectorio)
                            .addComponent(lExtension))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lErrores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfExtension, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(tfRuta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bBuscarRuta)
                            .addComponent(bBuscarExtension)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lRutaDirectorio)
                    .addComponent(tfRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscarRuta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lExtension)
                    .addComponent(tfExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscarExtension))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBuscarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarRutaActionPerformed
        String nombre="", extension="", tipoArchivo="";
        int posicion;
        float tamanio=0;
        File ruta;
        File[] contenidoRuta;
        //creamos el modelo para darle formato a la tabla que usaremos para mostrar el contenido
        DefaultTableModel modeloTDocumentos=new DefaultTableModel();
        //Array donde guardamos la información del archivo
        String[] propiedades=new String[4];
        //creamos un array para guardar los títulos de las columnas 
        Object[] tituloColumnas=new Object[4];
        tituloColumnas[0]="Nombre";
        tituloColumnas[1]="Extension";
        tituloColumnas[2]="Tamaño";
        tituloColumnas[3]="F/D";
        //pasamos los títulos de las columnas al modelo de la tabla
        modeloTDocumentos.setColumnIdentifiers(tituloColumnas);

        //Le pasamos a nuestra tabla el modelo que acabamos de crear
        tDocumentos.setModel(modeloTDocumentos);
        //creamos el puntero hacia la ruta ingresada por teclado
        ruta=new File(tfRuta.getText());
        if(tfRuta.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe ingresar primero una ruta");
            borrarCampos();
        }else{
            if (ruta.exists()){
                lErrores.setText(" ");
                //creamos el array para sacar lo que tengamos en el puntero de la ruta
                contenidoRuta=ruta.listFiles();
                //recorremos el array para sacar las propiedades de los documentos
                for(int i=0; i<contenidoRuta.length; i++){
                    nombre=contenidoRuta[i].getName();
                    //preguntamos si es un fichero para sacar su extensión
                    if(contenidoRuta[i].isFile()){
                        extension=contenidoRuta[i].getName();
                        posicion=extension.lastIndexOf(".");
                        extension=extension.substring(posicion+1);
                        tipoArchivo="F";
                    }else{
                        extension="";
                        tipoArchivo="D";
                    }
                    tamanio=contenidoRuta[i].length();
                    //crearemos las filas y le pasaremos las propiedades de los archivos que se encuentran dentro del array de propiedades
                    propiedades[0]=nombre;
                    propiedades[1]=extension;
                    propiedades[2]=String.valueOf(tamanio);
                    propiedades[3]=tipoArchivo;
                    //Le pasamos la información al modelo de la tabla
                    modeloTDocumentos.addRow(propiedades);
                }
            }else{
                lErrores.setText("La ruta especificada no existe");
                
            }
        }
    }//GEN-LAST:event_bBuscarRutaActionPerformed

    private void bBuscarExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarExtensionActionPerformed
        File ruta;
        //
        String nombre="", extension="", tipoArchivo="", buscarExtension="";
        int posicion;
        float tamanio=0;
        File[] contenidoRuta;
        //creamos el modelo para darle formato a la tabla que usaremos para mostrar el contenido
        DefaultTableModel modeloTDocumentos=new DefaultTableModel();
        //Array donde guardamos la información del archivo
        String[] propiedades=new String[4];
        //creamos un array para guardar los títulos de las columnas 
        Object[] tituloColumnas=new Object[4];
        tituloColumnas[0]="Nombre";
        tituloColumnas[1]="Extension";
        tituloColumnas[2]="Tamaño";
        tituloColumnas[3]="F/D";
        //pasamos los títulos de las columnas al modelo de la tabla
        modeloTDocumentos.setColumnIdentifiers(tituloColumnas);

        //Le pasamos a nuestra tabla el modelo que acabamos de crear
        tDocumentos.setModel(modeloTDocumentos);
        //comprobamos que la ruta no está vacía. Simplemente para evitar errores
        if(tfRuta.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe ingresar primero una ruta");
            borrarCampos();
        }
        else{
            ruta=new File(tfRuta.getText());
            if(ruta.exists()){
                lErrores.setText("");
                if(tfExtension.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "Debe ingresar la extensión por la cuál desea buscar");
                }else{
                    buscarExtension=tfExtension.getText();
                    //con este if controlamos que la extensión que introduzcan siempre tenga punto
                    if(buscarExtension.contains(".")){
                        posicion=buscarExtension.lastIndexOf(".");
                        buscarExtension=buscarExtension.substring(posicion+1);
                    }
                    //creamos el array para sacar lo que tengamos en el puntero de la ruta
                    contenidoRuta=ruta.listFiles();

                    //recorremos el array para sacar las propiedades de los documentos
                    for(int i=0; i<contenidoRuta.length; i++){
                        nombre=contenidoRuta[i].getName();
                        //preguntamos si es un fichero para sacar su extensión
                        if(contenidoRuta[i].isFile()){
                            extension=contenidoRuta[i].getName();
                            posicion=extension.lastIndexOf(".");
                            extension=extension.substring(posicion+1);
                            tipoArchivo="F";
                            tamanio=contenidoRuta[i].length();
                            //crearemos las filas y le pasaremos las propiedades de los archivos que se encuentran dentro del array de propiedades
                            if(extension.equals(buscarExtension)){
                                lErrores.setText("");
                                propiedades[0]=nombre;
                                propiedades[1]=extension;
                                propiedades[2]=String.valueOf(tamanio);
                                propiedades[3]=tipoArchivo;
                                //Le pasamos la información al modelo de la tabla
                                modeloTDocumentos.addRow(propiedades);
                            }else{
                              
                            }
                        }
                    }
                }
            }else{
                lErrores.setText("La ruta especificada no existe");
            }
        }
    }//GEN-LAST:event_bBuscarExtensionActionPerformed
    
    private void borrarCampos(){
        tfRuta.setText("");
        tfExtension.setText("");
        lErrores.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Explorador_Archivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Explorador_Archivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Explorador_Archivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Explorador_Archivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Explorador_Archivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscarExtension;
    private javax.swing.JButton bBuscarRuta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lErrores;
    private javax.swing.JLabel lExtension;
    private javax.swing.JLabel lRutaDirectorio;
    private javax.swing.JTable tDocumentos;
    private javax.swing.JTextField tfExtension;
    private javax.swing.JTextField tfRuta;
    // End of variables declaration//GEN-END:variables
}
