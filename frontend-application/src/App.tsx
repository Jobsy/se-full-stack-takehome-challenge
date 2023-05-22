import * as React from "react";
import { Route, Routes } from "react-router-dom";

import { MainLayout } from "./layout/MainLayout";
import { UserContext } from "./context/UserContext";
import { FavouriteProvider } from "./context/FavouriteContext";
import { FavouritePage, Home, SaleDetails, SearchResults } from "./pages";

export const App: React.FC = () => {
  const [userId, setUserId] = React.useState<string>(
    localStorage.getItem("SE_USER_ID") ?? ""
  );
  const handleSetUserId: (userId: string) => void = (userId) => {
    localStorage.setItem("SE_USER_ID", userId);
    setUserId(userId);
  };

  return (
    <UserContext.Provider value={{ userId, setUserId: handleSetUserId }}>
      <FavouriteProvider>
      <Routes>
        <Route path="/" element={<MainLayout />}>
          <Route path="/" element={<Home />} />
          <Route path="/sale/:id" element={<SaleDetails />} />
          <Route path="/search/:query" element={<SearchResults />} />
          <Route path="/search" element={<SearchResults />} />
          <Route path="/favourite/:id" element={<FavouritePage userId={userId}/>} />
        </Route>
      </Routes>
      </FavouriteProvider>
    </UserContext.Provider>
  );
};
