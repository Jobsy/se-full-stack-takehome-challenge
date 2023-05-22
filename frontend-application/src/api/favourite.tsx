
import axiosInstance from '../utils/axiosInstance';

  
export const addFavourite = async (userId: string, saleId: string): Promise<number> => {
    try {
      const response = await axiosInstance.post(`/favourites/add`, { userId, saleId });
      return response.data.statusCode;
    } catch (error) {
      throw error;
    }
};
  
export const getFavoritesByUserIdAndSaleId = async (userId: string, saleId: string): Promise<number> => {
    try {
      const response = await axiosInstance.get(`/favourites/getFavoritesByUserIdAndSaleId/${userId}/${saleId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
};  

export const getAllFavoritesByUserId = async (userId: string): Promise<string[]> => {
  try {
    const response = await axiosInstance.get(`/favourites/getAllFavoritesByUserId/${userId}`);
    return response.data;
  } catch (error) {
    throw error;
  }
}; 

export const deleteFavourite = async (userId: string, saleId: string): Promise<number> => {
    try {
      const response = await axiosInstance.delete(`/favourites/delete/${userId}/${saleId}`);
      return response.data.statusCode;
    } catch (error) {
      throw error;
    }
}; 