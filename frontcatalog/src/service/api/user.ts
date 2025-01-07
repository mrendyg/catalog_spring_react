import { axi } from "../AuthService";


export const loginRequest = async (email: string, password: string) => {
    const response = axi.post("/auth/login/", {email, password});
    return response;
}