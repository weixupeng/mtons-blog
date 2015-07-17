/**
 * 
 */
package mblog.web.controller.desk;

import java.net.MalformedURLException;

import mblog.analysis.videos.VideoAnalysis;
import mblog.data.Video;
import mtons.modules.pojos.Data;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author langhsu
 *
 */
@Controller
public class VideoController {
	@Autowired
	private VideoAnalysis videoRobot;
	
	@RequestMapping("/video/take")
	public @ResponseBody Data take(String url) {
		Data data = Data.failure("请求失败");
		if (StringUtils.isNotBlank(url)) {
			try {
				Video ret = videoRobot.take(url);
				data = Data.success(ret);
			} catch (MalformedURLException e) {
				data = Data.failure("网络错误");
			}
		}
		return data;
	}
}
