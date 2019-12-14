package fs;

import gui.Cliente;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Middleware extends UnicastRemoteObject implements FSInterfaz {
    ArrayList<FSInterfaz> clientes = new ArrayList<>();
    String name;
    Cliente frameCliente;
 public static final String ANSI_GREEN = "\u001B[32m";
 public static final String ANSI_RESET = "\u001B[0m";
    public Middleware() throws RemoteException {
        this.name = "SERVER";
    }

    public Middleware(String name, Cliente frameCliente) throws RemoteException {
        this.name = name;
        this.frameCliente = frameCliente;
    }
    
    @Override
    public String getName() {
        return name;
    }

    public Cliente getFrame() {
        return frameCliente;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<FSInterfaz> getClients() {
        return clientes;
    }

    @Override
    public void desmontar(String name) throws RemoteException {
        try {
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getName().equals(name)) {
                    clientes.remove(i);
                    System.out.println("Se desmonto correctamente: " + name);
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void broadcast(String fileChanged) throws RemoteException {
        for (FSInterfaz cliente : clientes) {
            cliente.send(fileChanged);
        }
    }

    @Override
    public void send(String fileChanged) throws RemoteException {
        System.out.println("Broadcast del servidor: " + fileChanged);
        // ver si el archivo que el cliente tiene abierto es el que se envio
        if (fileChanged.equals(frameCliente.abierto)) {
            // si es asi, decirle que hay un conflicto
            frameCliente.conflicto();
        } else {
            // volver a cargar la estructura
            frameCliente.cargarArchivo();
        }
    }
    
    @Override
    public DefaultTreeModel cargarDirectorio() throws RemoteException {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new FileConText(new File("RootServer"), "", false, true));
        cargarArbol("RootServer", root);/*CON RootServer carga el modelo que se */
        System.out.println("CARGO EL ARBOL");
        return new DefaultTreeModel(root);
    }

    @Override
    public void crearArchivo(File archivoaCrear, boolean esArchivo) throws RemoteException, IOException {
        // crear un archivo vacio
        // debe recibir la ruta completa, ej:
        // C:\\Users\\Nohelia\\RootServer\\341234\\12442\\creame\\laptops.txt
        
        File fileRes = pathRootServer(archivoaCrear);

        if (esArchivo) {
            fileRes.getParentFile().mkdirs();
            fileRes.createNewFile();
        } else {
            fileRes.mkdirs();
        }
    }

    @Override
    public void editarArchivo(File editandoArchivo, String texto) throws RemoteException {
        try {
            Files.write(Paths.get(editandoArchivo.getAbsolutePath()), texto.getBytes());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminarArchivo(File archivoaEliminar) throws RemoteException {
        // eliminar un archivo
        // debe recibir la ruta completa, ej:
        // C:\\Users\\Nohelia\\RootServer\\341234\\12442\\creame\\laptops.txt
        File fileRes = pathRootServer(archivoaEliminar);

        eliminarDirs(fileRes);
    }

    @Override
    public void agregarCliente(FSInterfaz cliente) throws RemoteException {
       
        System.out.println(ANSI_GREEN+"Montado, con el cliente:  " + cliente.getName()+ANSI_RESET);
        clientes.add(cliente);
    }
    
    public File pathRootServer(File archivo) {
        // debe recibir la ruta completa, ej:
        // C:\\Users\\XXXX\\RootServer\\carpeta\\archivo.txt

        String pathRes = archivo.getName();
        File parent = archivo;

        while (true) {
            parent = parent.getParentFile();
            if (parent.getName().equals("RootServer")) {
                break;
            }
            pathRes = parent.getName() + "/" + pathRes;
        }

        pathRes = "RootServer/" + pathRes;
        return new File(pathRes);
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
    
    public void cargarArbol(String dir, DefaultMutableTreeNode node) {
        File root = new File(dir);
        System.out.println("Cargando el arbol.....");
        File[] list = root.listFiles();
        System.out.println(ANSI_GREEN + "Arbol Cargado......" + ANSI_RESET);
        FileConText res;
         System.out.println(ANSI_GREEN + "Listando Archivos......" + ANSI_RESET);
        for (File file : list) {
            String filename = file.getName();
            System.out.println(filename);
            if (file.isFile()) {
                String texto = readFile(file.getAbsolutePath());
                res = new FileConText(file, texto, true, false);
                node.add(new DefaultMutableTreeNode(res));
            } else if (file.isDirectory()) {
                res = new FileConText(file, "", false, true);
                DefaultMutableTreeNode subdir = new DefaultMutableTreeNode(res);
                File subdirfile = new File(root.getAbsolutePath(),  filename);
                cargarArbol(subdirfile.getAbsolutePath(), subdir);
                node.add(subdir);
            }
        }
    }
    
    public static String readFile(String fileName) { 
        String data = ""; 
        try {
            data = new String(Files.readAllBytes(Paths.get(fileName))); 
        } catch (IOException e) {
            System.out.println(e);
        }
        return data; 
    } 
}