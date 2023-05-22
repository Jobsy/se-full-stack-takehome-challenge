import { useContext } from 'react';
import { faHeart } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import {
  DestenationText,
  FavouriteCardContent,
  FavouriteCardLink,
  TitleText,
} from './FavouriteCard.styles';
import { Favourite } from '../../utils/Favourite.interface';
import { FavouriteContext } from '../../context/FavouriteContext';

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
        <FontAwesomeIcon
          icon={faHeart}
          color={isFavourite ? '#BB0039' : '#7E7E7E'}
          onClick={() => toggleFavourite(favourite.id || "")}
        />
        <FavouriteCardLink to={`/sale/${favourite.id}`}>
          <img
            width="100%"
            src={favourite.photos?.[0].url}
            alt={favourite?.editorial?.title} />
          <FavouriteCardContent>
            <DestenationText>{favourite?.editorial?.destinationName}</DestenationText>
            <TitleText>{favourite?.editorial?.title}</TitleText>
          </FavouriteCardContent>
        </FavouriteCardLink>
      </>}
    </div>
  );
};