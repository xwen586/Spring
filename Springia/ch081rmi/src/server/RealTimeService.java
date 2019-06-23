package server;

public class RealTimeService implements IRmiService {

	@Override
	public String getMsg(String params) throws Exception {
		return "Real Time!" +  params;
	}

}
