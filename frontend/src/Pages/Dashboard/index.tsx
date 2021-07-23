import BarChart from "components/BarChart";
import DataTable from "components/DataTable";
import DonutChart from "components/DonutChart";
import Navbar from "components/NavBar";
import Pagination from "components/Pagination";
import { useState } from "react";
import { useSales } from "Services/hooks/Sales/UseSales";
import { useSalesAmountBySeller } from "Services/hooks/Sales/UseSalesAmountBySeller";
import { useSalesSuccessBySeller } from "Services/hooks/Sales/UseSalesSuccessBySeller";

const Dashboard = () => {
  const [page, setPage] = useState(0); 
  
  const {sales, salesPaginationSet, salesIsLoading} = useSales(page)
  const {amountBySeller, amountBySellerIsLoading} = useSalesAmountBySeller()
  const {successBySeller, successBySellerIsLoading} = useSalesSuccessBySeller()

  return (
    <>
      <Navbar />
      <div className="container">
        <h1 className="text-primary py-3">Dashboard de Vendas</h1>
        <div className="row px-3">
          
            {successBySellerIsLoading ? (
              <div>
                <p>loading...</p>
              </div>
            ) : (
              <div className="col-sm-6">
                <h5 className="text-center text-secondary">Taxa de sucesso</h5>
                <BarChart
                  successBySeller={successBySeller}
                />
              </div>
            )}
            {amountBySellerIsLoading ? (
            <div>
              <p>loading...</p>
            </div>
          ) : (
            <div className="col-sm-6">
              <h5 className="text-center text-secondary">Tocas as vendas</h5>
              <DonutChart
                amountBySeller={amountBySeller}
              />
            </div>  
          )}
        </div>
        <div className="py3">
          <h2 className="text-primary">Todas as Vendas</h2>
        </div>    
        {salesIsLoading ? (
          <div>
            <p>loading...</p>
          </div>
        ) : (
          <>
          <Pagination 
            page={salesPaginationSet}
            onPageChange={setPage}
          />
          <DataTable
            sales={sales}        
          />
          </>
        )}        
      </div>
    </>
  );
}

export default Dashboard;