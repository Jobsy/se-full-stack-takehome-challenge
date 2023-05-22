import { ISale } from "./Sale.interface";

export interface Favourite extends ISale {
    iD: number;
    userId: string;
    saleId: string;
}
  