import * as React from "react";
import { Outlet } from "react-router-dom";

import {
  ContentContainer,
  FlexWrapper,
  Header,
  Logo,
  StyledLink,
} from "./MainLayout.styles";
import { LoginButton } from "../components";

export const MainLayout: React.FC = (props) => {
  return (
    <>
      <Header>
        <ContentContainer>
          <FlexWrapper>
            <Logo />
            <LoginButton />
          </FlexWrapper>
          <ul>
            <li>
              <StyledLink to="/">Home</StyledLink>
            </li>
            <li>
              <StyledLink to="/search/London">London</StyledLink>
            </li>
            <li>
              <StyledLink to="/search/Paris">Paris</StyledLink>
            </li>
            <li>
              <StyledLink to="/search/Berlin">Berlin</StyledLink>
            </li>
            <li>
              <StyledLink to="/favourite/my-favourite">My Favourites</StyledLink>
            </li>
          </ul>
        </ContentContainer>
      </Header>
      <ContentContainer>
        <Outlet />
      </ContentContainer>
    </>
  );
};
