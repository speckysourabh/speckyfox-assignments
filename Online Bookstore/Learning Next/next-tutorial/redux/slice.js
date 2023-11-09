const { createSlice } = require("@reduxjs/toolkit");

const initialState = {
  token: [],
};
const slice = createSlice({
  name: "tokenSlice",
  initialState,
  reducers: {
    setToken: (state, action) => {
      console.log(action);
      state.token.push({
        token: action.payload,
      });
    },
  },
});

export const { setToken } = slice.actions;
export default slice.reducer;
