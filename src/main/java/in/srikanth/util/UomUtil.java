package in.srikanth.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class UomUtil {
	// 1. create Pie Chart
	public void generatePie(String path, List<Object[]> data) {
		// a. Create DataSet for Pie and add data to it
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : data) {
			// setValue(key[string],val[double])
			dataset.setValue(String.valueOf(ob[0]), Double.valueOf(ob[1].toString()));
		}
		// b. Create JFreeCharts object with dataset and other details
		JFreeChart chart = ChartFactory.createPieChart3D("UOM TYPE AND COUNT", dataset);
		// c. convert JFreeCharts object as image
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/uomA.jpg"),
					// path + file name
					chart, 500, 300); // chart obj, width, height
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 2. create Bar Chart
	public void generateBar(String path, List<Object[]> data) {
		// a. Create DataSet for Bar and add data to it
		// b. Create JFreeCharts object with dataset and other details
		// c. convert JFreeCharts object as image
	}
}