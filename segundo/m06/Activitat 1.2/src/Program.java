import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Program {
	
	public static void pausar(){
		
		Scanner scanner = new Scanner(System.in);
	    boolean exit = false;
	    
	    while(!exit) {
	    	
	    	System.out.println("Presione 'Enter' para continuar");
		    String readString = scanner.nextLine();

	        if (readString.isEmpty()) {
	        	System.out.println("\n \n");
	        	
	            exit = true;
	            
	        }
	    }
		
	}
	
	static int booleanToInteger(boolean booleano) {
		
		return  booleano ? 1 : 0;
	}
	
	static Date stringToDate(String strDate) {
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		
		try {
		    //Parsing the String
		    fecha = formatter.parse(strDate);
		    
		} catch (ParseException e) {
			
		    System.out.println("Error: " + e);
		}
		
		
		return fecha;
		
	}
	
	
	public static Client createClient() {
		
		boolean salir = false;
		boolean premium = false;
		Client cliente = null;
		Scanner teclado = new Scanner(System.in);
		
		
		while (!salir) {
			
			System.out.print("Introduzca el DNI (sin letra): ");
			if (teclado.hasNextInt()) {
				
				int dni = teclado.nextInt();
				System.out.print("Introduzca el nombre: ");
				teclado.nextLine();
				String nombre = teclado.nextLine();
				
				System.out.print("Es cliente premium? (1 para si y 0 para no):");
		    	
		    	if (teclado.hasNextInt() ) {
					
		    		int opcion = teclado.nextInt();
		    		
		    		if (opcion == 0 || opcion == 1) {
		    			
						if (opcion == 1) {
							premium = true;
						}
						
						salir = true;
						cliente = new Client(dni, nombre, premium);
						
					
		    		} else {
						System.out.println("Error: No se ha introducido 0 o 1");
					}
		    					    		
				} else {
					String entrada = teclado.nextLine();
					System.out.println("Error: " + entrada + " no es válido");
				}
				
				
				
			} else {
				String entrada = teclado.nextLine();
				System.out.println("Error: " + entrada + " no es válido");
				//System.out.println("Error: el DNI introducido no es correcto");
			}
			
		}
		
		return cliente;
		
	}
	
	static Client selectClient(ArrayList<Client> clientes) {
		
		Client cliente = null;
		Scanner teclado = new Scanner(System.in);
		
		int size = clientes.size();
		
		if (size > 0) {
			
			for (int i = 0; i < size; i++) {
				
				System.out.println((i + 1) + ") " + clientes.get(i).getDni() + " - " + clientes.get(i).getNom() + " \n");
				
			}
			
			System.out.print("Seleccione el cliente del pedido: ");
			
			if (teclado.hasNextInt()) {
				
				int opcion = teclado.nextInt();
				
				if (opcion >= 1 && opcion <= size) {
					
					cliente = clientes.get(opcion - 1);
					
				} else {
					System.out.println("Error: No se ha encontrado la opción introducida");
				}
				
			} else {
				System.out.println("Error: No se ha encontrado la opción introducida");
			}
			
		} else {
			System.out.println("No hay clientes registrados");
		}
		
		
		return cliente;
		
	}
	
	
	static void insertarCliente(Client cliente, Connection con) throws SQLException {
		
		int premium = booleanToInteger(cliente.isPremium()); //Booleano para formato SQL
		
		String sentenciaSQL = "INSERT INTO client (dni, nom, premium) VALUES (?,?,?)";
		PreparedStatement sentenciaPreparada = con.prepareStatement(sentenciaSQL);
		sentenciaPreparada.setString(1,cliente.getDni() + "");
		sentenciaPreparada.setString(2,cliente.getNom());
		sentenciaPreparada.setString(3,premium + "");
		int insercion = sentenciaPreparada.executeUpdate();
		
		if (insercion == 1) {
			
			System.out.println("Se ha añadido el cliente con DNI: " + cliente.getDni());
			
		} else {
			
			System.out.println("Ha ocurrido un error al insertar el cliente con DNI: " + cliente.getDni());
			
		}
		
	}
	
	
	static void insertarComanda(Comanda comanda, Connection con) throws SQLException {
		
		java.sql.Date sqlDate = new java.sql.Date(comanda.getData().getTime()); //Fecha paera formato SQL
		
		String sentenciaSQL = "INSERT INTO comanda (num_comanda, preu_total, data, dni_client) VALUES (?,?,?,?)";
		PreparedStatement sentenciaPreparada = con.prepareStatement(sentenciaSQL);
		sentenciaPreparada.setString(1,comanda.getNum_comanda() + "");
		sentenciaPreparada.setString(2,comanda.getPreu_total() + "");
		sentenciaPreparada.setString(3,sqlDate + "");
		sentenciaPreparada.setString(4,comanda.getClientDni() + "");
		int insercion = sentenciaPreparada.executeUpdate();
		
		if (insercion == 1) {
			
			System.out.println("Se ha añadido el pedido num " + comanda.getNum_comanda());
			
		} else {
			
			System.out.println("Ha ocurrido un error al insertar el pedido num: " + comanda.getNum_comanda());
			
		}
		
	}
	
	public static void deleteData(String tabla, Connection con) throws SQLException {
		
		
		String sentenciaSQL = "DELETE FROM " + tabla;
		
		PreparedStatement preparedStatement = con.prepareStatement(sentenciaSQL);
		preparedStatement.executeUpdate();
		
		
	}

	
	
	static Comanda createComanda(Client cliente) {

		Scanner teclado = new Scanner(System.in);
		
		boolean salir = false;
		Date fecha = null;
		int numComanda = 0;
		double preuTotal = 0;
		Comanda comanda = null;
		
		while (!salir) {
			
			System.out.print("Introduzca la fecha del pedido (yyyy-MM-dd): ");
			String date = teclado.next();
			fecha = stringToDate(date);
			
			if (fecha != null){
			    
			    System.out.print("Introduzca el número de pedido: ");
			    if (teclado.hasNextInt()) {
			    	
			    	numComanda = teclado.nextInt();
			    	
			    	System.out.print("Precio del pedido: ");
			    	
			    	if (teclado.hasNextDouble() ) {
						
			    		preuTotal = teclado.nextDouble();
			    		salir = true;
			    					    		
					} else {
						System.out.println("Error, no se ha introducido un número");
					}
			    	
			    	
			    } else {
			    	
			    	System.out.println("Error, no se ha introducido un número");
			    }
			    
			} else {

			    System.out.println("Error: fecha incorrecta");
			}
			
		}
				
		
		comanda = new Comanda(numComanda, preuTotal, fecha, cliente);
		
		return  comanda;
	}
	
	
	static ArrayList<Client> leerClientes(ArrayList<Client> clientes, Connection con) throws SQLException {
		
		Statement statement = con.createStatement();
		
		String sentenciaSQL = "SELECT * FROM client";
		ResultSet rs = statement.executeQuery(sentenciaSQL);
		
		int contador = 0;
		
		while (rs.next()) {
			
			int dni = rs.getInt("dni");
			String nombre = rs.getString("nom");
			boolean premium = rs.getBoolean("premium");
			
			clientes.add(new Client(dni, nombre, premium));
			
			contador++;
		}
		
		if(contador > 0) {
			
			System.out.println("Se han recuperado " + contador + " cliente(s)");
			
		} else {
			
			System.out.println("No se han recuperado clientes");
		}
		
		return clientes;
		
	}
	
	
	static ArrayList<Comanda> leerComandas(ArrayList<Comanda> comandas, ArrayList<Client> clientes, Connection con) throws SQLException {
		
		Statement statement = con.createStatement();
		
		String sentenciaSQL = "SELECT * FROM comanda";
		ResultSet rs = statement.executeQuery(sentenciaSQL);
		
		int contador = 0;
		
		while (rs.next()) {
			
			int numComanda = rs.getInt("num_comanda");
			double preuTotal = rs.getDouble("preu_total");
			Date fecha = stringToDate(rs.getString("data"));
			int dniCliente = rs.getInt("dni_client");
			
			Client cliente = null;
			
			for (Client client : clientes) {
				if (client.getDni() == dniCliente) {
					cliente = client;
					break;
				}
			}
			
			comandas.add(new Comanda(numComanda, preuTotal, fecha, cliente));
			
			contador++;
		}
		
		if(contador > 0) {
			
			System.out.println("Se han recuperado " + contador + " pedido(s)");
			
		} else {
			
			System.out.println("No se han recuperado comandas");
		}
		
		return comandas;
		
	}
	
	
	static void resumFact() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca el año: ");
		if (sc.hasNextInt()) {
			
			int anyo = sc.nextInt();
			
			if (anyo > 0) {
				
				System.out.print("Introduzca el mes (número): ");
				
				if (sc.hasNextInt()) {
					
					int mes = sc.nextInt();
								
					if (mes >= 1 && mes <= 12) {
						
						//HACER EÑ PROCEDIMIENTO
						MyBBDD driver = new MyBBDD();
						
						try {
							
							String sentenciaSQL = "CALL crea_resum_facturacio(" + mes + "," +  anyo + " );";
						
							Statement statement = driver.con.createStatement();
							statement.execute(sentenciaSQL);
							
							System.out.println("Se ha creado el resumen de facturación");
							driver.con.commit();
							
						} catch (Exception e) {
							
							System.out.println("Error: " + e);
							
							
						} finally {
							driver.close();							
						}
						
						
					} else {
						System.out.println("Error: El mes introducido no es válido");
					}
					
				} else {
					System.out.println("Error: No se ha introducido un número");
				}
				
			} else {
				System.out.println("Error: El mes introducido no es válido");
			}
			
		} else {
			System.out.println("Error: No se ha introducido un número");
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] ags) throws SQLException {
		
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		ArrayList<Client> clientes = new ArrayList<Client>();
		ArrayList<Comanda> comandas = new ArrayList<Comanda>();
		
		while (!salir) {
			
			System.out.println("Opciones: \n" +
					"0.- Salir \n" +
					"1.- Creació del model \n" +
					"2.- Recuperació de les dades de la BBDD \n" +
					"3.- Emmagatzemat de dades a la BBDD \n" +
					"4.- Alta d'un nou client \n" +
					"5.- Alta d'una nova comanda \n" +
					"6.- Mostrar per pantalla les comandes d'un client \n" + 
					"7.- Generació de resum de facturació \n\n\n");
				System.out.print("Introduzca una opción: ");
				
				if (teclado.hasNextInt()) {
					
					int opcion = teclado.nextInt();
					
					switch (opcion) {
					
					case 0:
						
						System.out.println("Opcion 0");
						System.out.println("Saliendo...");
						salir = true;
						break;
					
					case 1:
						
						System.out.println("Opcion 1");
						MyBBDD driver = new MyBBDD();
						
						try {
							
							String sentenciaSQL = "CREATE TABLE client ("
							+ "dni INT(8) PRIMARY KEY,"
							+ "nom VARCHAR(20),"
							+ "premium BOOLEAN"
							+ "); ";
						
						Statement statement = driver.con.createStatement();
						statement.execute(sentenciaSQL);
						
						sentenciaSQL = "CREATE TABLE comanda ("
								+ "num_comanda INT PRIMARY KEY,"
								+ "preu_total DOUBLE(40, 2),"
								+ "data DATE,"
								+ "dni_client INT(8),"
								+ "FOREIGN KEY (dni_client) REFERENCES client(dni)"
								+ ");";
						
						
						statement.execute(sentenciaSQL);
						
							
						} catch ( SQLSyntaxErrorException e) {
							
							System.out.println("Error: Las tablas ya existen");
						
						
						}catch (Exception e) {
							
							System.out.println("Error: " + e);
							
							
						} finally {
							driver.close();							
						}
						
						pausar();
						break;
						
					case 2:
						
						System.out.println("Opcion 2");
						driver = new MyBBDD();
						
						try {
							
							clientes = leerClientes(clientes, driver.con);
							comandas = leerComandas(comandas, clientes,  driver.con);							
							
						} catch (Exception e) {
							
							System.out.println("Error: " + e);
							
							
						} finally {
							driver.close();							
						}
						
						pausar();
						break;
					case 3:
						
						System.out.println("Opcion 3");
						
						driver = new MyBBDD();
						
						
						try {
							
							deleteData("comanda", driver.con);
							deleteData("client", driver.con);
							
							
							for (Client client : clientes) {
								
								insertarCliente(client, driver.con);
							}
							
							for (Comanda comanda : comandas) {
								insertarComanda(comanda, driver.con);
							}
							
						} catch (Exception e) {
							System.out.println("Error: " + e);
							
						} finally {
							
							driver.close();							
						}
						
						
						pausar();
						break;
					case 4:
						
						System.out.println("Opcion 4");
						
						Client cliente = createClient();
						
						int size = clientes.size();
						
						if (size > 0) {
							
							boolean hayIguales = false;
							boolean exit = false;
							int contador = 0;
							
							while(!exit) {
								
								if (clientes.get(contador).equals(cliente)) {
									
									hayIguales = true;
									
								}
								
								contador++;
								
								if (hayIguales || contador >= size) {
									exit = true;
								}
								
							}
							
							if (!hayIguales) {
								
								clientes.add(cliente);
								
							} else {
								System.out.println("No se ha añadido el cliente con DNI: " + cliente.getDni() + ", ya existe");
							}
							
						} else {
							
							clientes.add(cliente);
						}
						
						
						pausar();
						break;
					case 5:
						
						System.out.println("Opcion 5");
						cliente = selectClient(clientes);
						
						if (cliente != null) {
							
							comandas.add(createComanda(cliente));
						}
						
						pausar();
						break;
						
						
					case 6:
						
						System.out.println("Opcion 6");
						cliente = selectClient(clientes);
						
						if(cliente != null) {
							
							for (Comanda comanda : comandas) {
								
								if (comanda.getClient().getDni() == cliente.getDni()) {
									
									System.out.println("\nNum. Comanda: " + comanda.getNum_comanda());
									System.out.println("Fecha: " + comanda.getData());
									//System.out.println("Cliente: " + comanda.getClientDni() + " - " + comanda.getClient().getNom());
									System.out.println("Precio total: " + comanda.getPreu_total() + "€");
									
								}
							}
							
						}
						
						pausar();
						break;
						
					case 7:
						
						System.out.println("Opcion 7");
						
						resumFact();
						
						
						pausar();
						break;

					default:
						System.out.println("Error: el múmero introducido no es una opción");
						pausar();
						break;
					}
					
				} else {
					
					
					String entrada = teclado.nextLine();
					System.out.println("Error: " + entrada + " no es válido");
					//System.out.println("Error: no se ha introducido un número");
					pausar();
				}
				
			
		}
		
		
	}

}
