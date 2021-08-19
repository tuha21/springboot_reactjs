import { Component } from "react"
import LoginService from "../../services/loginservice/LoginService";
import * as action from "../../actions";
import {connect} from "react-redux";

class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: "",
            password: "",
            alert: {
                status: false,
                value: true,
                message: ""
            }
        }
    }

    onChangeHand = event => {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    onSubmit = event => {
        event.preventDefault();
        LoginService.login(this.state.username, this.state.password)
            .then(response => {
                if (response.status === 500) {
                    this.setState({
                        alert: {
                            status: true,
                            value: false,
                            message: "Username or Password is not correct !"
                        }
                    })
                }
                else if (response.status === 200) {
                    this.setState({
                        alert: {
                            status: true,
                            value: true,
                            message: "Sign in complete !"
                        }
                    })
                }
                return response.text();
            })
            .then(result => {
                console.log(result)
                let user = JSON.parse(result)
                let auth = {
                    id: user.id,
                    username: user.username,
                    password: user.password,
                    roles: user.roles
                }
                this.props.setAuth(auth);
                this.props.setCart([])
            })
            .catch(error => console.log('error', error));
    }

    render() {
        var alert = this.state.alert.status === false ? <div></div> :
            <div className={this.state.err ? "disable" : this.state.alert.value ? "alert alert-primary" : "alert alert-danger"} role="alert">
                {this.state.alert.message}
            </div>
        return (
            <div className="row">
                <div className='col'></div>
                <div className='col'>
                    <div className='p-5'>
                        <h3>Login</h3>
                        <form className='mt-3' onSubmit={this.onSubmit}>
                            <div className="mb-3">
                                <label>Username</label>
                                <input className="form-control border border-3 rounded-0" type="text" name="username" onChange={this.onChangeHand} placeholder="enter username here" />
                            </div>
                            <div className="mb-3">
                                <label>Password</label>
                                <input className="form-control border border-3 rounded-0" type="password" name="password" onChange={this.onChangeHand} placeholder="enter password here" />
                            </div>
                            {alert}
                            <button className="mt-3 p-0 pt-2 btn w-100 rounded-0" style={{ backgroundColor: '#A3C7BD' }}>
                                <h5 style={{ color: 'white' }}>Sign in</h5>
                            </button>
                        </form>
                    </div>
                </div>
                <div className='col'></div>
            </div>
        )
    }
}


const mapStateToProps = state => {
    return {
        auth : state.auth
    }
}

const mapDispatchToProps = dispatch => {
    return {
        setAuth: auth => {
            dispatch(action.setAuth(auth))
        },
        setCart: cart => {
            dispatch(action.setCart(cart))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps) (Login);