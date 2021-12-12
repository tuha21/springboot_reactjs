import { Component } from "react";
import CartItem from "./CartItem";
import { Link } from "react-router-dom"
import { connect } from "react-redux"
import Paypal from "./PayPal";
class Cart extends Component {

    constructor(props) {
        super(props);
        this.state = {
            paymentMethod: 0, // 0: cod 1: paypal
            isShowPaypal: false
        }
    }

    onPay = () => {
        if (this.state.paymentMethod === 1) {
            this.setState({
                isShowPaypal: true
            })
        }
    }

    render() {
        var { cart } = this.props
        var subTotal = 0;
        var element = cart.map((val, ind) => {
            subTotal += val.prod.price * val.qty
            return <CartItem key={ind}
                cartItem={val}
                deleteFromCart={this.props.deleteFromCart}
                updateCart={this.props.updateCart}
            />
        })
        return (
            <div className='row m-0 mt-5'>
                <div className='col-md-2'></div>
                <div className='col-md-8'>
                    <div className='row'>
                        <div className='col-md-7' style={{ borderRight: "1px solid lightgray" }}>
                            <div>
                                <h4>Giỏ hàng</h4>
                                <table>
                                    <tbody>
                                        {element}
                                    </tbody>
                                </table>
                                <br />
                                <select className="form-select" aria-label="Default select example">
                                    <option selected>Chọn mã giảm giá</option>
                                    <option value="1">Miễn phí vận chuyển</option>
                                    <option value="1">Giảm giá 10% cho đơn hàng lớn hơn 300k</option>
                                </select>
                                <br />
                                <table className='w-100 mb-4'>
                                    <tbody>
                                        <tr className='border border-start-0 border-end-0 border-top-1 border-bottom-1'>
                                            <td className='row pt-3'>
                                                <div className='col-6 text-start pb-3'>Tạm tính</div>
                                                <div className='col-6 text-end pb-3'>{subTotal}$</div>
                                                <div className='col-6 text-start pb-3'>Mã giảm giá</div>
                                                <div className='col-6 text-end pb-3'>0đ</div>
                                                {/* <div className='col-6 text-start pb-3'>Tiền ship</div>
                                            <div className='col-6 text-end pb-3'>FREE</div> */}
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <h4>Tổng tiền: {subTotal}$</h4>
                            </div>
                        </div>
                        <div className='col-md-5'>
                            <div>
                                <h4>Thông tin thanh toán</h4>
                                <form>
                                    <div className="mb-3">
                                        <label for="name" className="form-label">Tên người nhận hàng</label>
                                        <input type="text" className="form-control" id="name"
                                            name="name"
                                        />
                                    </div>
                                    <div className="mb-3">
                                        <label for="exampleInputEmail1" className="form-label">Email</label>
                                        <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                                            name="email"
                                        />
                                    </div>
                                    <div className="mb-3">
                                        <label for="phone" className="form-label">Số điện thoại</label>
                                        <input type="number" className="form-control" id="phone"
                                            name="phone"
                                        />
                                    </div>
                                    <div className="mb-3">
                                        <label for="exampleInputEmail1" className="form-label">Địa chỉ nhận hàng</label>
                                        <input type="text" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                                            name="address"
                                        />
                                    </div>
                                    <div className="mb-3">
                                        <div className="row">
                                            <div className="col-4">
                                                <select className="form-control" value={0}>
                                                    <option>Thành phố</option>
                                                    <option>Hồ Chí Minh</option>
                                                </select>
                                            </div>
                                            <div className="col-4">
                                                <select className="form-control" value={0}>
                                                    <option>Quận/Huyện</option>
                                                    <option>Hồ Chí Minh</option>
                                                </select>
                                            </div>
                                            <div className="col-4">
                                                <select className="form-control" value={0}>
                                                    <option>Phường/Xã</option>
                                                    <option>Hồ Chí Minh</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                {/* <Link className="mt-3 p-0 pt-2 btn w-100 rounded-0" style={{ backgroundColor: '#ADA3A0' }} to="/sges/checkout">
                                <h5 style={{ color: 'white' }}><i className="bi bi-bag-fill pe-2"></i>Đến trang thanh toán</h5>
                            </Link> */}
                            </div>
                            <div className="mt-5">
                                <h4>Hình thức thanh toán</h4>
                                <div className="form-check">
                                    <input
                                        checked={this.state.paymentMethod === 0}
                                        onClick={() => this.setState({ paymentMethod: 0, isShowPaypal: false })}
                                        className="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" />
                                    <label className="form-check-label" for="flexRadioDefault1">
                                        Thanh toán khi nhận hàng (COD)
                                    </label>
                                </div>
                                <div className="form-check">
                                    <input
                                        checked={this.state.paymentMethod === 1}
                                        onClick={() => this.setState({ paymentMethod: 1 })}
                                        className="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" />
                                    <label className="form-check-label" for="flexRadioDefault2">
                                        Thanh toán bằng ví điện tử
                                    </label>
                                </div>
                                <button className="mt-3 w-100 btn-checkout" onClick={this.onPay}>Thanh toán</button>
                                <div className="mt-3">
                                    {this.state.isShowPaypal ? <Paypal totalPay={10} /> : ""}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className='col-md-2'></div>
            </div>
        );
    }
}

const mapStateToProps = state => {
    return {
        cart: state.cart
    }
}

const mapDispatchToProps = dispatch => {
    return {

    }
}
export default connect(mapStateToProps, mapDispatchToProps)(Cart);