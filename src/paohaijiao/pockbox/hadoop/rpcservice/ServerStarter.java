package paohaijiao.pockbox.hadoop.rpcservice;


import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Builder;
import org.apache.hadoop.ipc.RPC.Server;


public class ServerStarter {

	
	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		
		Configuration conf = new Configuration();
		Builder builder = new RPC.Builder(conf);
		builder.setInstance(new LoginServiceImpl()).setBindAddress("yun12-01").setPort(10000).setProtocol(LoginServiceInterface.class);
		Server server = builder.build();
		server.start();
		
		
	}
}
