import * as React from "react";
import { ISale } from "../../utils/Sale.interface";
import { faHeart } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

import {
  DestenationText,
  SaleCardContent,
  SaleCardLink,
  TitleText,
} from "./SaleCard.styles";
import { FavouriteContext } from "../../context/FavouriteContext";

interface ISaleCardProps {
  sale: Partial<ISale>;
}

export const SaleCard: React.FC<ISaleCardProps> = ({ sale }) => {

  const { favourites, toggleFavourite } = React.useContext(FavouriteContext);

  const isFavourite = favourites.includes(sale.id || "");
  const userId = localStorage.getItem("SE_USER_ID");

  return (
    <div>
      {userId && <FontAwesomeIcon
        icon={faHeart}
        color={isFavourite ? '#BB0039' : '#7E7E7E'}
        onClick={() => toggleFavourite(sale.id || "")}
      />}
      
      <SaleCardLink to={`/sale/${sale.id}`}>
        <img
          width="100%"
          src={sale.photos?.[0].url}
          alt={sale?.editorial?.title}
        />
        <SaleCardContent>
          <DestenationText>{sale?.editorial?.destinationName}</DestenationText>
          <TitleText>{sale?.editorial?.title}</TitleText>
        </SaleCardContent>
      </SaleCardLink>
    </div>
  );
};
