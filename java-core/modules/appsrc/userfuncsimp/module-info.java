module userfuncsimp {
    requires userfuncs;

    provides userfuncs.binaryfuncs.BinFuncProvider with
            userfuncsimp.binaryfuncsimp.AbsMinusProvider,
            userfuncsimp.binaryfuncsimp.AbsPlusProvider;
}