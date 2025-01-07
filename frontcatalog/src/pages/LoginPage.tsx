import LoginForm from "../components/LoginForm";



const LoginPage = () =>{
    return(
        <>
        <div className="flex">
        <div className="flex h-screen w-full">
            <img src="src/img/man-driving-car-from-rear-view.jpg" className="object-cover w-6/12 h-full"/>

            <div className="flex items-center justify-center w-1/2 h-full">
                <LoginForm />
            </div>
        </div>
        </div>
        

        </>
    )
}

export default LoginPage;