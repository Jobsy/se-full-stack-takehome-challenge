import * as React from "react";

import { FavouriteCard } from "../../components";
import { ISale } from "../../utils/Sale.interface";
import { Favourite } from '../../utils/Favourite.interface';
import { useFetchFavouriteSale } from '../../utils/UseFetchFavouriteSale';

interface Props {
  userId: string;
}

export const FavouritePage: React.FC<Props> = ({ userId }) => {
  const [favourites, setFavourites] = React.useState<Partial<Favourite>[]>([]);
  const { sales, loading, error  } = useFetchFavouriteSale({ saleIds: favourites.map(favourite => favourite.saleId) });
  const storedFavourites = localStorage.getItem(`favourites_${userId}`);

  function filterSalesByFavourites(sales: ISale[] | Partial<Favourite> | any, favouriteId: string | any[] | null) {
    try {
      // Filter sales by whether their id is in the favouriteId array
      const filteredSales = sales?.filter((sale: { id: any; }) => favouriteId?.includes(sale.id));
      return filteredSales;
    } catch (error) {
      // Handle any errors that occur during filtering
      console.error("Error filtering sales by favourites:", error);
      return [];
    }
  }
  
  const favourite = filterSalesByFavourites(sales, storedFavourites)
  
  return (
    <>
      {loading && <div>Loading...</div>}
      {error && <div>Error fetching sales...</div>}
      {favourite?.length === 0 && <div>No favourites added yet.</div>}
      {userId && favourite?.map((sale: Partial<Favourite>, idx: React.Key) => (
        <FavouriteCard key={idx} favourite={sale} />
      ))}
    </>
  );
};