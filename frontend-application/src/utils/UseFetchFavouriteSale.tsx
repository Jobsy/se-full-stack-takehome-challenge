import { DocumentNode, gql, useQuery } from "@apollo/client";
import { ISale } from "./Sale.interface";

interface IUseFetchFavouriteSaleProps {
  saleIds: (string | undefined)[];
}

interface IUseFetchFavouriteSale {
  sales: ISale[];
  loading: boolean;
  error: any;
}

const GET_FAVOURITE_SALES_QUERY: DocumentNode = gql`
  query SaleSearch($saleIds: [String!]!) {
    saleSearch(saleIds: $saleIds) {
      sales {
        id
        editorial {
          title
          destinationName
        }
        photos {
          url
        }
      }
    }
  }
`;

export const useFetchFavouriteSale: (props: IUseFetchFavouriteSaleProps) => IUseFetchFavouriteSale = ({
  saleIds,
}) => {
  const { data, loading, error } = useQuery(GET_FAVOURITE_SALES_QUERY, {
    variables: {
      saleIds,
    },
  });

  return { sales: data?.saleSearch?.sales, loading, error };
};
