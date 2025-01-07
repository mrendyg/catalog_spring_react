
import { useMutation } from "@tanstack/react-query";
import { loginRequest } from "../service/api/user";
import { useNavigate } from "react-router-dom";
import toast from "react-hot-toast";
import { useState } from "react";


const LoginForm = () =>{


    // const navigate = useNavigate();


    // const [email, setEmail] = useState('');
    // const [password, setPassword] = useState('');

    // const loginMutation = useMutation({
    //     mutationFn:() => loginRequest(email, password),
    //     onSuccess: (response) => {
    //         console.log(response)
    //        // setToken(response.data.access, response.data.refresh);
    //         navigate("/");
    //     },
    //     onError: (error) => {
    //         if (typeof error === 'string') {
    //           toast.error(error);
    //         } else {
    //           toast.error('An error occurred');
    //         }
    //       },
    // });

    // const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    //     event.preventDefault();
    //     loginMutation.mutate();
    // }


    return(
        <div className="flex flex-col items-center justify-center bg-[#3DB1EB] px-6 py-8 mx-auto md:h-[600px] lg:py-0">
            
            <div className="w-full md:w-[400px] lg:w-[500px] md:mt-0 sm:max-w-md xl:p-0">
                <div className="p-6 space-y-4 md:space-y-6 sm:p-8">
                    <h1 className="text-xl text-center text-[#FFFFFF] font-bold leading-tight tracking-tight md:text-2xl ">
                        Iniciar sesión
                    </h1>

                    <form className="space-y-4 md:space-y-6" 
                    // onSubmit={handleSubmit}
                    >
                        <div>
                            <label htmlFor="email" className="block mb-2 text-sm font-medium text-[#FFFFFF]">Usuario</label>
                            <input type="email" name="email" id="email"
                            // value={email}
                            // onChange={(e) => setEmail(e.target.value)}
                                className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" placeholder="name@company.com"/>
                        </div>

                        <div>
                            <label htmlFor="password" className="block mb-2 text-sm font-medium text-[#FFFFFF]">Contraseña</label>
                            <input type="password" name="password" id="password" 
                                // value={password}
                                // onChange={(e) => setPassword(e.target.value)}
                                placeholder="••••••••" className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"/>
                        </div>

                        <button type="submit" className="w-full text-white bg-[#3D7AEB] hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Iniciar sesion</button>


                    </form>
                </div>
            </div>
        </div>

    )
}

export default LoginForm;