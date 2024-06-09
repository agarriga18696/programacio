package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

import modelo.ExcepcionUsuario;
import modelo.Usuario;
import vista.Mensaje;

public class ControladorUsuario {

	// Ruta fichero guardado usuarios.
	private final String ruta = "data/users";
	private final String fichero = "usuarios.dat";
	private final String rutaCompleta = ruta + File.separator + fichero;

	// Atributos.
	private Set<Usuario> usuarios;

	// Constructor.
	public ControladorUsuario() {
		usuarios = cargarUsuariosFichero();
	}

	// Método para eliminar un usuario.
	public void eliminarUsuario(Usuario usuario) {
		// Verificar si el usuario existe.
		if(usuarios.contains(usuario)) {
			usuarios.remove(usuario);

			// Sobreescribir el fichero con el usuario eliminado.
			guardarUsuariosFichero();

			// Eliminar las partidas guardadas del usuario en data/savegames.
			eliminarFicheroPartidas(usuario);

			// Eliminar el archivo de configuración del usuario en data/config.
			eliminarFicheroConfiguracion(usuario);

		} else {
			Mensaje.error(null, "El usuario '" + usuario.getNombre() + "' no existe.");
		}
	}

	// Método para eliminar las partidas guardadas del usuario.
	private void eliminarFicheroPartidas(Usuario usuario) {
		File directorio = new File("data/savegames");

		if(directorio.exists()) {
			for(File archivo : directorio.listFiles()) {
				if(archivo.getName().startsWith("partidas_" + usuario.getNombre().toLowerCase())) {
					archivo.delete();
				}
			}
		}
	}

	// Método para eliminar el archivo de configuración del usuario.
	private void eliminarFicheroConfiguracion(Usuario usuario) {
		File directorio = new File("data/config");

		if(directorio.exists()) {
			for(File archivo : directorio.listFiles()) {
				if(archivo.getName().startsWith("config_" + usuario.getNombre().toLowerCase())) {
					archivo.delete();
				}
			}
		}
	}

	// Método para registrar un nuevo usuario.
	public void registrarUsuario(String nombre, String clave) throws ExcepcionUsuario {
		if (nombre.isEmpty() || clave.isEmpty()) {
			throw new ExcepcionUsuario("El nombre de usuario y la clave no pueden estar vacíos.");
		}

		if(!comprobarSiUsuarioExiste(nombre)) {
			Usuario nuevoUsuario = new Usuario(nombre.trim(), clave);
			usuarios.add(nuevoUsuario);
			guardarUsuariosFichero();

		} else {
			throw new ExcepcionUsuario("El usuario ya existe.");
		}
	}

	// Método para comprobar que el nuevo usuario no esté registrado.
	private boolean comprobarSiUsuarioExiste(String nombre) {
		return usuarios.stream().anyMatch(usuario -> nombre.trim().equalsIgnoreCase(usuario.getNombre()));
	}

	// Método para autenticar el inicio de sesión de un usuario.
	public Usuario autenticarUsuario(String nombre, String clave) throws ExcepcionUsuario {
		// Comprobar que el los campos no estén vacíos.
		if((nombre.isEmpty() || clave.isEmpty())) {
			throw new ExcepcionUsuario("El nombre de usuario y la clave no pueden estar vacíos.");
		}

		for(Usuario usuario : usuarios) {
			if (usuario.getNombre().trim().equals(nombre) && usuario.getClave().equals(clave)) {
				return usuario;
			}
		}

		throw new ExcepcionUsuario("El nombre de usuario o la clave son incorrectos.");
	}

	// Método para comprobar si hay algún usuario registrado.
	public boolean hayUsuariosRegistrados() {
		return !usuarios.isEmpty();
	}

	// Método para guardar usuarios en el fichero.
	private void guardarUsuariosFichero() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaCompleta))) {
			oos.writeObject(usuarios);

		} catch(IOException e) {
			throw new RuntimeException("Error al intentar guardar los usuarios en el archivo.", e);
		}
	}

	// Método para cargar los usuarios del fichero.
	@SuppressWarnings("unchecked")
	private Set<Usuario> cargarUsuariosFichero() {
		Set<Usuario> usuarios = new HashSet<>();

		comprobarDirectorio(ruta);

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaCompleta))) {
			// Verificar que el archivo contenga datos válidos.
			Object objeto = ois.readObject();
			if (objeto instanceof Set) {
				usuarios = (Set<Usuario>) objeto;
			} else {
				throw new IOException("El archivo de usuarios no contiene una lista de usuarios válida.");
			}

		} catch (FileNotFoundException e) {
			// El archivo no existe.
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException("Error al cargar los usuarios.", e);
		}

		return usuarios;
	}

	// Método para verificar si el directorio existe.
	private void comprobarDirectorio(String rutaDirectorio) {
		// Si el directorio no existe, crear uno nuevo.
		File directorio = new File(rutaDirectorio);
		if(!directorio.exists()) {
			directorio.mkdirs();
		}
	}

}
