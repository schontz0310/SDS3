export default interface SalesData {
  id: number;
  seller: {
    id: number,
    name: string,
  },
  visited: number,
  deals: number,
  amount: number,
  date: Date,
}
