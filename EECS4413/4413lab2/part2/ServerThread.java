import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ServerThread extends Thread {
    Socket ClientSocket;
    String ClientString;
    String ReplyString;
    Table table;
    ArrayList<userClass> u;

    public ServerThread(Socket s, Table table) {
        this.ClientSocket = s;
        this.table = table;

    }

    @Override
    public void run() {
        System.out.println("listening...");
        try {

            int flag = 0;
            String[] client_name = null;
            String c_name = "";
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(ClientSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(ClientSocket.getOutputStream());
            while ((ClientString = inFromClient.readLine()) != null) {
                flag = command_checker(ClientString);
                if (flag == 0) {
                    flag = 0;
                    System.out.println("WRONG COMMAND");
                    ReplyString = "COMMAND DOES NOT EXIST";
                    outToClient.println(ReplyString);
                    outToClient.flush();
                } else if (flag == 6) {
                    System.out.println("Client exit");
                    flag = 0;
                    ReplyString = "quit";
                    output(ClientString,c_name);
                    outToClient.println(ReplyString);
                    outToClient.flush();
                    break;
                }else if (flag == 1) {
                    flag = 0;
                    String output = output(ClientString,c_name);
                    ReplyString = output;
                    client_name = output.split(" ");
                    c_name = client_name[0];     
                    outToClient.println(ReplyString);
                    outToClient.flush();
                } else if (flag == 2) {
                    flag = 0;
                    System.out.println("querying...  " + ClientString + "\n");
                    output(ClientString, c_name);
                    String re = "";
                    if (u.size() == 0) {
                        outToClient.println(" ");
                    } else {
                        for (int i = 0; i < u.size(); i++) {
                            re += u.get(i).getName() + " " + u.get(i).getType() + " ";
                            //
                            // outToClient.println(u.get(i).getName() + " " + u.get(i).getType());
                        }
                        outToClient.println(re);
                        u = null;
                    }
                    outToClient.flush();

                }
            }
        } catch (Exception e) {
            ;
        }

    }

    public int command_checker(String clientCommand) {
        int flag = 0;
        // if flag =1, correct command
        // if flag =2 quit
        String[] str = null;
        str = clientCommand.split(" ");

        if (str[0].equals("register") && str.length == 3) {
            if (str[2].equals("ugrad") || str[2].equals("grad") || str[2].equals("faculty")) {
                flag = 1;
            }
        } else if (str[0].equals("query") && str.length == 2) {
            if (str[1].equals("ugrad")) {
                flag = 2;
            } else if (str[1].equals("grad")) {
                flag = 2;
            } else if (str[1].equals("faculty")) {
                flag = 2;
            } else if (str[1].equals("all")) {
                flag = 2;
            }
        } else if (str[0].equals("quit") && str.length == 1) {
            flag = 6;
        }

        return flag;
    }

    public String output(String clientCommand, String name) {
        String result = "";
        String[] str = null;
        str = clientCommand.split(" ");
        int checker_flag = command_checker(clientCommand);
        if (str[0].equals("register") && str.length == 3 && checker_flag == 1) {
            if (str[2].equals("ugrad") || str[2].equals("grad") || str[2].equals("faculty")) {
                int flag = 0;
                flag = table.register(str[1], str[2]);
                if (flag == 1) {
                    result = str[1] + " register success";
                    
                  
                } else {
                    result = "That Name Already Exists";
                }

            }
        } else if (str[0].equals("query") && str.length == 2 && checker_flag == 2) {

            if (str[1].equals("ugrad")) {
                u = table.query_ugrad();

            } else if (str[1].equals("grad")) {
                u = table.query_grad();

            } else if (str[1].equals("faculty")) {
                u = table.query_faculty();

            } else if (str[1].equals("all")) {
                u = table.query_all();
            }
        } else if (str[0].equals("quit") && str.length == 1 && checker_flag == 6) {
            table.quit(name);
            
        }

        return result;
    }
}
