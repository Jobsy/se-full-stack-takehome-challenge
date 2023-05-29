import { useContext } from 'react';
import { faHeart } from '@fortawesome/free-solid-svg-icons';

import {
  FavouriteCardContainer,
  StyledFontAwesomeIcon,
} from './FavouriteCard.styles';
import { Favourite } from '../../utils/Favourite.interface';
import { FavouriteContext } from '../../context/FavouriteContext';
import { DestenationText, SaleCardContent, SaleCardLink, TitleText } from '../SaleCard/SaleCard.styles';

interface FavouriteCardProps {
  favourite: Partial<Favourite>;
}

export const FavouriteCard: React.FC<FavouriteCardProps> = ({ favourite }) => {
  const { favourites, toggleFavourite } = useContext(FavouriteContext);
  const isFavourite = favourites.includes(favourite.id || "");

return (
  <div>
    {isFavourite && 
    <>
      <FavouriteCardContainer>
        <StyledFontAwesomeIcon
          icon={faHeart}
          color={isFavourite ? '#BB0039' : '#7E7E7E'}
          onClick={() => toggleFavourite(favourite.id || "")}
        />
        <SaleCardLink to={`/sale/${favourite.id}`}>
          <img
            width="100%"
            src={favourite.photos?.[0].url}
            alt={favourite?.editorial?.title} />
          <SaleCardContent>
            <DestenationText>{favourite?.editorial?.destinationName}</DestenationText>
            <TitleText>{favourite?.editorial?.title}</TitleText>
          </SaleCardContent>
        </SaleCardLink>
      </FavouriteCardContainer>
    </>
    }
  </div>);
};
