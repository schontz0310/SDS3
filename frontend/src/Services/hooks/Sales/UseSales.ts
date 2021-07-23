import { AxiosResponse } from "axios"
import PageProps from "DTOs/IPageprops"
import SalesData from "DTOs/ISales"
import { useQuery } from "react-query"
import api from "Services/api"

const DEFAULT_PAGE = 0
const DEFAULT_SIZE = 20
const DEFAULT_SORT = 'date'
const DEFAULT_ORDER = 'desc'   

const salesSearchConfig = {
  page: DEFAULT_PAGE,
  size: DEFAULT_SIZE,
  sort: DEFAULT_SORT,
  order: DEFAULT_ORDER
}

interface SalesQueryResponse extends PageProps{
  content: SalesData[];
  pageable: Object;
  sort: Object;       
}

interface ResponseFormatted{
  paginationSet:PageProps;
  content: SalesData[];
}



async function getSales(page: Number): Promise<ResponseFormatted> {
  try{
    const response: AxiosResponse<SalesQueryResponse> = await api.prodApi.get(`/sales?page=${page}&size=${salesSearchConfig.size}&sort=${salesSearchConfig.sort},${salesSearchConfig.order}`)
    const formattedResponse: ResponseFormatted = {
      content: response.data.content,
      paginationSet: {
        empty: response.data.empty,
        first: response.data.first,
        last: response.data.last,
        number: response.data.number,
        numberOfElements: response.data.numberOfElements,
        size: response.data.size,
        totalElements: response.data.totalElements,
        totalPages: response.data.totalPages,
      }
    } 
    
    return formattedResponse
  }catch(error){
    throw new Error(error);
    
  }
}

export function useSales(page: Number){
  const response  = useQuery(['sales', page], () => getSales(page))
  return {
    sales: response.data?.content,
    salesPaginationSet: response.data?.paginationSet,
    salesIsLoading: response.isLoading,
  }
}




