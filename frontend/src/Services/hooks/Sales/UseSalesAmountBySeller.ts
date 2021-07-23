import { AxiosResponse } from "axios"
import SellerSalesSum from "DTOs/ISellerSalesSum"
import { useQuery } from "react-query"
import api from "Services/api"

async function getSalesAmountBySeller(): Promise<SellerSalesSum[]> {
  try{
    const response: AxiosResponse<SellerSalesSum[]> = await api.prodApi.get('/sales/amount-by-seller')
    return response.data
  }catch(error){
    throw new Error(error);
  }
}

export function useSalesAmountBySeller(){
  const response = useQuery('salesAmountBySeller', () => getSalesAmountBySeller())
  return {
    amountBySeller: response.data,
    amountBySellerIsLoading: response.isLoading,
  }
}




