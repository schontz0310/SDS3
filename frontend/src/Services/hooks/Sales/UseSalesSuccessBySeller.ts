import { AxiosResponse } from "axios"
import SellerSuccess from "DTOs/ISellerSuccess"
import { useQuery } from "react-query"
import api from "Services/api"

async function getSalesSuccessBySeller(): Promise<SellerSuccess[]> {
  try{
    const response: AxiosResponse<SellerSuccess[]> = await api.prodApi.get('/sales/success-by-seller')
    return response.data
  }catch(error){
    throw new Error(error);
  }
}

export function useSalesSuccessBySeller(){
  const response = useQuery('salesSuccessBySeller', () => getSalesSuccessBySeller())
  return {
    successBySeller: response.data,
    successBySellerIsLoading: response.isLoading,
  }
}




