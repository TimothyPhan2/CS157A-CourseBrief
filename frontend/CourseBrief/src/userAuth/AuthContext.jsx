import React, {useContext, useState, useEffect} from "react";

export const AuthContext = React.createContext({
    user: null,
    login: () => {},
    logout: () => {},
    });

    export function AuthProvider({ children }) {
        const [user, setUser] = useState(null);
    
        useEffect(() => {
            const storedUser = localStorage.getItem('user');
            if (storedUser) {
                setUser(JSON.parse(storedUser));
            }
        }, []);
    
        const login = (userData) => {
            setUser(userData);
            localStorage.setItem('user', JSON.stringify(userData));
        };
    
        const logout = () => {
            setUser(null);
            localStorage.removeItem('user');
        };
    
        return (
            <AuthContext.Provider value={{ user, login, logout }}>
                {children}
            </AuthContext.Provider>
        );
    }