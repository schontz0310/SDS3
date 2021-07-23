import SalesData from "DTOs/ISales";
import './DataTable.css' 
interface DataTableProps{
  sales: SalesData[] | undefined,
}



const DataTable = ({sales}: DataTableProps) => {
  return (
    <div className="table-box">
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th>Data</th>
              <th>Vendedor</th>
              <th>Clientes visitados</th>
              <th>Negócios fechados</th>
              <th>Valor</th>
              <th>Data</th>
              <th>Vendedor</th>
              <th>Clientes visitados</th>
              <th>Negócios fechados</th>
              <th>Valor</th>
            </tr>
          </thead>
          <tbody>
            {sales && (
              sales.map( sale => (
                <tr key={sale.id}>
                  <td>{sale.date}</td>
                  <td>{sale.seller.name}</td>
                  <td>{sale.visited}</td>
                  <td>{sale.deals}</td>
                  <td>{sale.amount}</td>
                  <td>{sale.date}</td>
                  <td>{sale.seller.name}</td>
                  <td>{sale.visited}</td>
                  <td>{sale.deals}</td>
                  <td>{sale.amount}</td>
                </tr>
              ))
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}


export default DataTable;