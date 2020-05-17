import { createContext, useContext } from 'react';

const defaultUser = {
  id: 0, 
  password: '', 
  username: '',
  emailAddress: '',
  userRole: 'GUEST' 
}

export const AuthContext = createContext({
  defaultUser,
  setAuthTokens: () => {},
});

export const AuthProvider = AuthContext.Provider;
export const AuthConsumer = AuthContext.Consumer;

export function useAuth() {
  return useContext(AuthContext);
}