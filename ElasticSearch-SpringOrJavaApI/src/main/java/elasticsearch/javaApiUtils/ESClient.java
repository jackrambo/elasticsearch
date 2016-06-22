package elasticsearch.javaApiUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import common.ConfigPropertiesUtil;

/***
* @ClassName: ESClient 
* @Description: TODO(Java原生ApiClient) 
* @author Yashiro 
* @date 2016-6-3 上午11:35:45 
*/
public class ESClient {

	public static Client client = javaTcpClient();
	
	public static Client javaTcpClient(){
		
		String ip = ConfigPropertiesUtil.getProperty("es.ip");
		String port = ConfigPropertiesUtil.getProperty("es.tcp.port");
		String clusterName = ConfigPropertiesUtil.getProperty("es.cluster.name");
	
		Client client = null;
		try {
			client = TransportClient.builder().settings(Settings.settingsBuilder()
					.put("client.transport.sniff",true)
					.put("cluster.name",clusterName).build()).build()
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ip),new Integer(port)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return client;
	}
}
