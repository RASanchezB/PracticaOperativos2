package gui;

import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import fs.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class Cliente extends javax.swing.JFrame {
public static final String ANSI_PURPLE = "\u001B[35m";
 public static final String ANSI_RESET = "\u001B[0m";
    private static final String IP = "192.168.0.4";
    private static final int PUERTO = 1100; 

    public Registry registry;
    public FSInterfaz servidor;
    public FSInterfaz cliente;
    public String archivo_abierto;

    public Cliente() throws RemoteException, NotBoundException {
        initComponents();
        nombre = JOptionPane.showInputDialog(this, "Identifiquese:", "Bienvenido", JOptionPane.QUESTION_MESSAGE);
        cliente = new Middleware(nombre, this);
        System.setProperty("java.rmi.server.hostname", "192.168.0.4");
        registry = LocateRegistry.getRegistry(IP, PUERTO);
        System.out.println(ANSI_PURPLE+"REGISTRADO EN EL PUERTO "+PUERTO+ANSI_RESET);
        System.out.println("Buscando........");
        servidor = (FSInterfaz) registry.lookup("fs");
        System.out.println(ANSI_PURPLE+"Cliente Agregado."+ANSI_RESET);
        servidor.agregarCliente(cliente);
        System.out.println("Cargando Archivo....");
        cargarArchivo();
        System.out.println(ANSI_PURPLE+"Archivos Cargados"+ANSI_RESET);
        ta_archivo.setVisible(false);
        btn_guardar.setVisible(false);
        jLabel1.setText(nombre);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenuDir = new javax.swing.JPopupMenu();
        crearArchivo = new javax.swing.JMenuItem();
        crearDir = new javax.swing.JMenuItem();
        eliminarDir = new javax.swing.JMenuItem();
        popMenuArchivo = new javax.swing.JPopupMenu();
        abrirArchivo = new javax.swing.JMenuItem();
        eliminarArchivo = new javax.swing.JMenuItem();
        popMenuRoot = new javax.swing.JPopupMenu();
        crearArchivo1 = new javax.swing.JMenuItem();
        crearDir1 = new javax.swing.JMenuItem();
        eliminarDir1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_cargarArchivo = new javax.swing.JButton();
        bt_desmontarFS = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_archivo = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolCliente = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();

        crearArchivo.setText("Crear Archivo");
        crearArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearArchivoActionPerformed(evt);
            }
        });
        popMenuDir.add(crearArchivo);

        crearDir.setText("Crear Directorio");
        crearDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearDirActionPerformed(evt);
            }
        });
        popMenuDir.add(crearDir);

        eliminarDir.setText("Eliminar Directorio");
        eliminarDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarDirActionPerformed(evt);
            }
        });
        popMenuDir.add(eliminarDir);

        abrirArchivo.setText("Abrir Archivo");
        abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArchivoActionPerformed(evt);
            }
        });
        popMenuArchivo.add(abrirArchivo);

        eliminarArchivo.setText("Eliminar Archivo");
        eliminarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarArchivoActionPerformed(evt);
            }
        });
        popMenuArchivo.add(eliminarArchivo);

        popMenuRoot.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        popMenuRoot.setName(""); // NOI18N

        crearArchivo1.setText("Crear Archivo");
        crearArchivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearArchivo1ActionPerformed(evt);
            }
        });
        popMenuRoot.add(crearArchivo1);

        crearDir1.setText("Crear Directorio");
        crearDir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearDir1ActionPerformed(evt);
            }
        });
        popMenuRoot.add(crearDir1);

        eliminarDir1.setText("Eliminar Directorio");
        eliminarDir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarDir1ActionPerformed(evt);
            }
        });
        popMenuRoot.add(eliminarDir1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vista del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel1.setText("Cliente");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones del Cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N

        btn_cargarArchivo.setBackground(new java.awt.Color(255, 255, 255));
        btn_cargarArchivo.setText("Cargar Directorios");
        btn_cargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarArchivoActionPerformed(evt);
            }
        });

        bt_desmontarFS.setBackground(new java.awt.Color(255, 255, 255));
        bt_desmontarFS.setText("Desmontar FS");
        bt_desmontarFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_desmontarFSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_cargarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bt_desmontarFS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btn_cargarArchivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_desmontarFS)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones del TXT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N

        btn_guardar.setBackground(new java.awt.Color(255, 255, 255));
        btn_guardar.setText("Guardar");
        btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_guardar)
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Archivo Abierto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        ta_archivo.setColumns(20);
        ta_archivo.setRows(5);
        jScrollPane2.setViewportView(ta_archivo);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Directorios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        arbolCliente.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arbolCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arbolClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(arbolCliente);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jLabel2.setText("Bienvenido:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarArchivoActionPerformed
        try {
            DefaultTreeModel modelo = servidor.cargarDirectorio();
            arbolCliente.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_cargarArchivoActionPerformed

    private void bt_desmontarFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_desmontarFSActionPerformed

        try {
            if (!montar) {
                bt_desmontarFS.setText("Desmontar FS");
                arbolCliente.setEnabled(true);
                btn_cargarArchivo.setEnabled(true);
                montar = !montar;
                servidor.agregarCliente(cliente);
                cargarArchivo();
            } else {
                servidor.desmontar(nombre);

                // cerrar el archivo
                archivo_abierto = "";
                ta_archivo.setVisible(false);
                btn_guardar.setVisible(false);
                // volver a cargar la estructura
                bt_desmontarFS.setText("Montar FS");
                arbolCliente.setEnabled(false);
                btn_cargarArchivo.setEnabled(false);
                montar = !montar;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_bt_desmontarFSActionPerformed

    private void arbolClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arbolClienteMouseClicked
        arbolCliente.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        if (evt.isMetaDown()) {
            int row = arbolCliente.getClosestRowForLocation(evt.getX(), evt.getY());
            arbolCliente.setSelectionRow(row);
            Object v1 = arbolCliente.getSelectionPath().getLastPathComponent();
            nodo_seleccionado = (DefaultMutableTreeNode) v1;
            if (nodo_seleccionado.getUserObject() instanceof FileConText) {
                archivo_seleccionado = ((FileConText) nodo_seleccionado.getUserObject()).getFile();
                fct_seleccionado = (FileConText) nodo_seleccionado.getUserObject();
                if (fct_seleccionado.isDir) {
                    popMenuDir.show(evt.getComponent(), evt.getX(), evt.getY());
                } else {
                    popMenuArchivo.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            } else if (nodo_seleccionado.isRoot()) {
                popMenuRoot.show(evt.getComponent(), evt.getX(), evt.getY());
            }

        }
    }//GEN-LAST:event_arbolClienteMouseClicked

    private void crearDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearDirActionPerformed
        String path = pathArchivo();
        String name = JOptionPane.showInputDialog(this, "Nombre del Directorio");
        path = path.concat(name);
        path = path.concat("/");
        File dir = new File(path);

        try {
            servidor.crearArchivo(dir, false);
            JOptionPane.showMessageDialog(this, "Directorio creado exitosamente");
        } catch (Exception e) {
            System.out.println(e);
        }
        cargarArchivo();

    }//GEN-LAST:event_crearDirActionPerformed
    private void eliminarDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarDirActionPerformed
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) arbolCliente.getLastSelectedPathComponent();
        String path = pathArchivo();
        path = path.concat("/");
        File dir = new File(path);

        try {
            servidor.eliminarArchivo(dir);
            JOptionPane.showMessageDialog(this, "Directorio eliminado exitosamente");
        } catch (Exception e) {
            System.out.println(e);
        }
        cargarArchivo();
    }//GEN-LAST:event_eliminarDirActionPerformed
    private void eliminarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarArchivoActionPerformed
        DefaultTreeModel modelo = (DefaultTreeModel) arbolCliente.getModel();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) arbolCliente.getLastSelectedPathComponent();
        String path = pathArchivo();
        //path = path.concat("/");
        File dir = new File(path);
        try {
            servidor.eliminarArchivo(dir);
            JOptionPane.showMessageDialog(this, "Archivo eliminado exitosamente");
        } catch (Exception e) {
            System.out.println(e);
        }
        cargarArchivo();
    }//GEN-LAST:event_eliminarArchivoActionPerformed
    private void crearArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearArchivoActionPerformed
        String path = pathArchivo();
        String name = JOptionPane.showInputDialog(this, "Ingrese el nombre del archivo (sin el .txt)");
        path = path.concat(name);
        path = path.concat(".txt");
        path = path.concat("/");
        File archivo = new File(path);
        try {
            servidor.crearArchivo(archivo, true);
            JOptionPane.showMessageDialog(this, "Archivo creado exitosamente");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Ocurrió un error");
        }
        cargarArchivo();
    }//GEN-LAST:event_crearArchivoActionPerformed
    private void crearArchivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearArchivo1ActionPerformed
        String path = pathArchivo();
        String name = JOptionPane.showInputDialog(this, "Ingrese el nombre del archivo (sin el .txt)");
        path = path.concat(name);
        path = path.concat("/");
        File archivo = new File(path);
        try {
            servidor.crearArchivo(archivo, true);
            JOptionPane.showMessageDialog(this, "Archivo creado exitosamente");
        } catch (Exception e) {
            System.out.println(e);
        }
        cargarArchivo();

    }//GEN-LAST:event_crearArchivo1ActionPerformed
    private void crearDir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearDir1ActionPerformed
        String path = pathArchivo();
        String name = JOptionPane.showInputDialog(this, "Ingrese el nombre del directorio");
        path = path.concat(name);
        path = path.concat("/");
        File dir = new File(path);

        try {
            servidor.crearArchivo(dir, false);
            JOptionPane.showMessageDialog(this, "Directorio creado exitosamente");
        } catch (Exception e) {
            System.out.println(e);
        }
        cargarArchivo();

    }//GEN-LAST:event_crearDir1ActionPerformed
    private void eliminarDir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarDir1ActionPerformed
        String path = pathArchivo();
        //path = path.concat("/");
        File dir = new File(path);
        System.out.println(path);

        try {
            servidor.eliminarArchivo(dir);
            JOptionPane.showMessageDialog(this, "Directorio eliminado exitosamente");
        } catch (Exception e) {
            System.out.println(e);
        }
        cargarArchivo();    
    }//GEN-LAST:event_eliminarDir1ActionPerformed
    private void abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArchivoActionPerformed
        ta_archivo.setText(fct_seleccionado.getText());
        ta_archivo.setVisible(true);
        btn_guardar.setVisible(true);
        archivo_abierto = dirLocalServer(new File(fct_seleccionado.getFile().getAbsolutePath()));
        System.out.println(ANSI_PURPLE+"Archivo : " + archivo_abierto+" abierto exitosamente"+ANSI_RESET);
    }//GEN-LAST:event_abrirArchivoActionPerformed
    private void btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseClicked
        try {
            servidor.editarArchivo(archivo_seleccionado, ta_archivo.getText());
            archivo_abierto = "";
            JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        cargarArchivo();
        ta_archivo.setVisible(false);
        btn_guardar.setVisible(false);
    }//GEN-LAST:event_btn_guardarMouseClicked
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.out.println("Cerrando...");
        try {
            servidor.desmontar(nombre);
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_formWindowClosing

    public void conflicto() {
        JOptionPane.showMessageDialog(this, "Se detectó un conflicto con el archivo que tiene abierto:\n" + archivo_abierto);
        // cerrar el archivo
        archivo_abierto = "";
        ta_archivo.setVisible(false);
        btn_guardar.setVisible(false);
        cargarArchivo();
    }
    
    public void cargarArchivo() {
        try {
            
            DefaultTreeModel modelo = servidor.cargarDirectorio();
            
            arbolCliente.setModel(modelo);
            
            // reset del cache en el cliente
            resetCache();
            
            // Recorrer todos los archivos en el arbol
            recorrer((DefaultMutableTreeNode) arbolCliente.getModel().getRoot());
            System.out.println(ANSI_PURPLE+"Archivo Cargado exitosamente"+ANSI_RESET);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void recorrer(DefaultMutableTreeNode nodo) throws IOException {
        // Recorrer todos los archivos en el arbol para imprimir su información
        FileConText file = (FileConText) nodo.getUserObject();
        boolean isFile = file.isFile;
        boolean isDir = file.isDir;

        File local = new File(dirLocal(file.getFile()));
        System.out.println("Recorriendo arbol....");
        if (isFile) {
            local.getParentFile().mkdirs();
            local.createNewFile();
            writeFile(local.getAbsolutePath(), file.getText());
        }

        if (isDir) {
            local.mkdirs();
        }

        if (nodo.isLeaf()) {
            return;
        }
        for (int i = 0; i < nodo.getChildCount(); i += 1) {
            recorrer((DefaultMutableTreeNode) nodo.getChildAt(i));
        }
    }

    public String dirLocalServer(File dirServer) {
        // Obtener el dir local, dado el del server
        String[] split = dirServer.getAbsolutePath().split("RootServer");
        if (split.length == 1) {
            return "RootServer";
        }
        return "RootServer" + split[1];
    }
    
    public String dirLocal(File dirServer) {
        // Obtener el directorio local, dado el del server
        String[] split = dirServer.getAbsolutePath().split("RootServer");
        if (split.length == 1) {
            return "RootClient" + nombre;
        }
        return "RootClient" + nombre + split[1];
    }

    public void writeFile(String filename, String text) {
        try {
            Files.write(Paths.get(filename), text.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void resetCache() {
        File rootClient = new File("RootClient" + nombre);

        // Borrar el directorio de cache del cliente
        eliminarDirs(rootClient);

        // Volver a crear el directorio
        rootClient.mkdirs();
    }

    public void eliminarDirs(File root) {
        File[] allContents = root.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                eliminarDirs(file);
            }
        }
        root.delete();
    }

    public void regenerar() {
        try {
            DefaultTreeModel modelo = servidor.cargarDirectorio();
            arbolCliente.setModel(modelo);
            arbolCliente.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            arbolCliente.setSelectionRow(0);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Cliente().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public String pathArchivo() {
        String ruta = "";
        arbolCliente.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) arbolCliente.getLastSelectedPathComponent();
        for (int i = 0; i < node.getPath().length; i++) {
            ruta = ruta.concat(node.getPath()[i].toString());
            ruta = ruta.concat("/");

        }

        return ruta;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirArchivo;
    private javax.swing.JTree arbolCliente;
    private javax.swing.JButton bt_desmontarFS;
    private javax.swing.JButton btn_cargarArchivo;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JMenuItem crearArchivo;
    private javax.swing.JMenuItem crearArchivo1;
    private javax.swing.JMenuItem crearDir;
    private javax.swing.JMenuItem crearDir1;
    private javax.swing.JMenuItem eliminarArchivo;
    private javax.swing.JMenuItem eliminarDir;
    private javax.swing.JMenuItem eliminarDir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu popMenuArchivo;
    private javax.swing.JPopupMenu popMenuDir;
    private javax.swing.JPopupMenu popMenuRoot;
    private javax.swing.JTextArea ta_archivo;
    // End of variables declaration//GEN-END:variables
    DefaultMutableTreeNode nodo_seleccionado;
    File archivo_seleccionado;
    File raiz;
    FileConText fct_seleccionado;
    String nombre;
    boolean montar = true;
}
