
import SellerSuccess from 'DTOs/ISellerSuccess';
import Chart from 'react-apexcharts'



interface BarChartProps{
  successBySeller: SellerSuccess[] | undefined;

}

const BarChart = ({
  successBySeller,
}: BarChartProps) => {

  const options = {
    plotOptions: {
        bar: {
            horizontal: true,
        }
    },
};
const sellers = successBySeller?.map(seller => seller.sellerName)
const success = successBySeller?.map(seller => ((seller.deals / seller.visited) * 100).toFixed(2))

const dataChart = {
    labels: {
        categories: sellers
    },
    series: [
        {
            name: "% Sucesso",
            data: success                  
        }
    ]
};

  return (
    <Chart 
      options={{...options, xaxis: dataChart.labels}}
      series={dataChart.series}
      type="bar"
      height="240"
    />
  );
}

export default BarChart;