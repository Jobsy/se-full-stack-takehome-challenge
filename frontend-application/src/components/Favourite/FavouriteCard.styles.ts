import { Link } from "react-router-dom";
import styled from "styled-components";

export const FavouriteCardLink = styled(Link)`
  filter: drop-shadow(0px 2px 4px rgba(0, 0, 0, 0.25));
  background: #fff;
  border-radius: 4px;
  display: block;
  width: 50%;
  padding: 0;
  margin-bottom: 20px;
  text-decoration: none;
  color: #000;
`;

export const FavouriteCardContent = styled.div`
  padding: 2px 14px 6px 4px;
`;

export const DestenationText = styled.div`
  font-weight: 400;
  font-size: 12px;
  line-height: 150%;
  /* Neutral / Grey 60 */
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 1;
  -webkit-box-orient: vertical;
  color: #3d4052;
`;

export const TitleText = styled.div`
  font-weight: 700;
  font-size: 20px;
  line-height: 125%;

  /* Neutral/Black 05 */
  color: #1e1f26;

  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
`;