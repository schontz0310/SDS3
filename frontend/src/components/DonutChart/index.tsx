import SellerSalesSum from 'DTOs/ISellerSalesSum'
import Chart from 'react-apexcharts'

interface DonutChartProps{
  amountBySeller: SellerSalesSum[] | undefined;

}


const DonutChart = ({amountBySeller}: DonutChartProps) => {


  const sellers = amountBySeller?.map(seller => seller.sellerName)
  const salesSum = amountBySeller?.map(seller => seller.sellerSaleSum)
  

const options = {
    legend: {
        show: true
    }
}

  return (
    <Chart 
      options={{...options, labels: sellers}}
      series={salesSum}
      type="donut"
      height="240"
    />
  );
}

export default DonutChart;