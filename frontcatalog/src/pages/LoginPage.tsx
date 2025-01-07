import LoginForm from "../components/LoginForm";



const LoginPage = () =>{
    return(
        <>
        <div className="flex">
        <div className="flex h-screen w-full">
            <div className="h-full">
            <img src="src/img/loginpanel.jpg" className="object-cover h-full"/>
            </div>
            <div className="flex items-center justify-center w-1/2 h-full">
                <LoginForm />
            </div>
        </div>
        </div>
        

        </>
    )
}

export default LoginPage;